package ec.com.smx.sic.articulo.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.ImagingOpException;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;

import ec.com.smx.sic.cliente.common.Logeable;

public class ResizeUtil
{
  public static final String DEBUG_PROPERTY_NAME = "imgscalr.debug";
  public static final String LOG_PREFIX_PROPERTY_NAME = "imgscalr.logPrefix";
  public static final boolean DEBUG = Boolean.getBoolean("imgscalr.debug");

  public static final String LOG_PREFIX = System.getProperty("imgscalr.logPrefix", "[imgscalr] ");

  public static final ConvolveOp OP_ANTIALIAS = new ConvolveOp(new Kernel(3, 3, new float[] { 0.0F, 0.08F, 0.0F, 0.08F, 0.68F, 0.08F, 0.0F, 0.08F, 0.0F }), 1, null);

  public static final RescaleOp OP_DARKER = new RescaleOp(0.9F, 0.0F, null);

  public static final RescaleOp OP_BRIGHTER = new RescaleOp(1.1F, 0.0F, null);

  public static final ColorConvertOp OP_GRAYSCALE = new ColorConvertOp(ColorSpace.getInstance(1003), null);
  public static final int THRESHOLD_BALANCED_SPEED = 1600;
  public static final int THRESHOLD_QUALITY_BALANCED = 800;

  public static BufferedImage apply(BufferedImage src, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    long t = System.currentTimeMillis();

    if (src == null)
      throw new IllegalArgumentException("src cannot be null");
    if ((ops == null) || (ops.length == 0)) {
      throw new IllegalArgumentException("ops cannot be null or empty");
    }
    int type = src.getType();

    if ((type != 1) && (type != 2)) {
      src = copyToOptimalImage(src);
    }
    if (DEBUG) {
      log(0, "Applying %d BufferedImageOps...", new Object[] { Integer.valueOf(ops.length) });
    }
    boolean hasReassignedSrc = false;

    for (int i = 0; i < ops.length; i++) {
      long subT = System.currentTimeMillis();
      BufferedImageOp op = ops[i];

      if (op == null) {
        continue;
      }
      if (DEBUG) {
        log(1, "Applying BufferedImageOp [class=%s, toString=%s]...", new Object[] { op.getClass(), op.toString() });
      }

      Rectangle2D resultBounds = op.getBounds2D(src);

      if (resultBounds == null) {
        throw new ImagingOpException("BufferedImageOp [" + op.toString() + "] getBounds2D(src) returned null bounds for the target image; this should not happen and indicates a problem with application of this type of op.");
      }

      BufferedImage dest = createOptimalImage(src, (int)Math.round(resultBounds.getWidth()), (int)Math.round(resultBounds.getHeight()));

      BufferedImage result = op.filter(src, dest);

      if (hasReassignedSrc) {
        src.flush();
      }

      src = result;

      hasReassignedSrc = true;

      if (DEBUG) {
        log(1, "Applied BufferedImageOp in %d ms, result [width=%d, height=%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - subT), Integer.valueOf(result.getWidth()), Integer.valueOf(result.getHeight()) });
      }

    }

    if (DEBUG) {
      log(0, "All %d BufferedImageOps applied in %d ms", new Object[] { Integer.valueOf(ops.length), Long.valueOf(System.currentTimeMillis() - t) });
    }

    return src;
  }

  public static BufferedImage crop(BufferedImage src, int width, int height, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return crop(src, 0, 0, width, height, ops);
  }

  public static BufferedImage crop(BufferedImage src, int x, int y, int width, int height, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    long t = System.currentTimeMillis();

    if (src == null)
      throw new IllegalArgumentException("src cannot be null");
    if ((x < 0) || (y < 0) || (width < 0) || (height < 0)) {
      throw new IllegalArgumentException("Invalid crop bounds: x [" + x + "], y [" + y + "], width [" + width + "] and height [" + height + "] must all be >= 0");
    }

    int srcWidth = src.getWidth();
    int srcHeight = src.getHeight();

    if (x + width > srcWidth) {
      throw new IllegalArgumentException("Invalid crop bounds: x + width [" + (x + width) + "] must be <= src.getWidth() [" + srcWidth + "]");
    }

    if (y + height > srcHeight) {
      throw new IllegalArgumentException("Invalid crop bounds: y + height [" + (y + height) + "] must be <= src.getHeight() [" + srcHeight + "]");
    }

    if (DEBUG) {
      log(0, "Cropping Image [width=%d, height=%d] to [x=%d, y=%d, width=%d, height=%d]...", new Object[] { Integer.valueOf(srcWidth), Integer.valueOf(srcHeight), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(width), Integer.valueOf(height) });
    }

    BufferedImage result = createOptimalImage(src, width, height);
    Graphics g = result.getGraphics();

    g.drawImage(src, 0, 0, width, height, x, y, x + width, y + height, null);

    g.dispose();

    if (DEBUG) {
      log(0, "Cropped Image in %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - t) });
    }

    if ((ops != null) && (ops.length > 0)) {
      result = apply(result, ops);
    }
    return result;
  }

  public static BufferedImage pad(BufferedImage src, int padding, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return pad(src, padding, Color.BLACK, new BufferedImageOp[0]);
  }

  public static BufferedImage pad(BufferedImage src, int padding, Color color, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    long t = System.currentTimeMillis();

    if (src == null)
      throw new IllegalArgumentException("src cannot be null");
    if (padding < 1) {
      throw new IllegalArgumentException("padding [" + padding + "] must be > 0");
    }
    if (color == null) {
      throw new IllegalArgumentException("color cannot be null");
    }
    int srcWidth = src.getWidth();
    int srcHeight = src.getHeight();

    int sizeDiff = padding * 2;
    int newWidth = srcWidth + sizeDiff;
    int newHeight = srcHeight + sizeDiff;

    if (DEBUG) {
      log(0, "Padding Image from [originalWidth=%d, originalHeight=%d, padding=%d] to [newWidth=%d, newHeight=%d]...", new Object[] { Integer.valueOf(srcWidth), Integer.valueOf(srcHeight), Integer.valueOf(padding), Integer.valueOf(newWidth), Integer.valueOf(newHeight) });
    }

    boolean colorHasAlpha = color.getAlpha() != 255;
    boolean imageHasAlpha = src.getTransparency() != 1;
    BufferedImage result;
    //BufferedImage result;
    if ((colorHasAlpha) || (imageHasAlpha)) {
      if (DEBUG) {
        log(1, "Transparency FOUND in source image or color, using ARGB image type...", new Object[0]);
      }

      result = new BufferedImage(newWidth, newHeight, 2);
    }
    else {
      if (DEBUG) {
        log(1, "Transparency NOT FOUND in source image or color, using RGB image type...", new Object[0]);
      }

      result = new BufferedImage(newWidth, newHeight, 1);
    }

    Graphics g = result.getGraphics();

    g.setColor(color);
    g.fillRect(0, 0, newWidth, newHeight);

    g.drawImage(src, padding, padding, null);
    g.dispose();

    if (DEBUG) {
      log(0, "Padding Applied in %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - t) });
    }

    if ((ops != null) && (ops.length > 0)) {
      result = apply(result, ops);
    }
    return result;
  }

  public static BufferedImage resize(BufferedImage src, int targetSize, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetSize, targetSize, ops);
  }

  public static BufferedImage resize(BufferedImage src, Method scalingMethod, int targetSize, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, scalingMethod, Mode.AUTOMATIC, targetSize, targetSize, ops);
  }

  public static BufferedImage resize(BufferedImage src, Mode resizeMode, int targetSize, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, Method.AUTOMATIC, resizeMode, targetSize, targetSize, ops);
  }

  public static BufferedImage resize(BufferedImage src, Method scalingMethod, Mode resizeMode, int targetSize, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, scalingMethod, resizeMode, targetSize, targetSize, ops);
  }

  public static BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetWidth, targetHeight, ops);
  }

  public static BufferedImage resize(BufferedImage src, Method scalingMethod, int targetWidth, int targetHeight, BufferedImageOp[] ops)
  {
    return resize(src, scalingMethod, Mode.AUTOMATIC, targetWidth, targetHeight, ops);
  }

  public static BufferedImage resize(BufferedImage src, Mode resizeMode, int targetWidth, int targetHeight, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    return resize(src, Method.AUTOMATIC, resizeMode, targetWidth, targetHeight, ops);
  }

  public static BufferedImage resize(BufferedImage src, Method scalingMethod, Mode resizeMode, int targetWidth, int targetHeight, BufferedImageOp[] ops)
    throws IllegalArgumentException, ImagingOpException
  {
    long t = System.currentTimeMillis();

    if (src == null)
      throw new IllegalArgumentException("src cannot be null");
    if (targetWidth < 0)
      throw new IllegalArgumentException("targetWidth must be >= 0");
    if (targetHeight < 0)
      throw new IllegalArgumentException("targetHeight must be >= 0");
    if (scalingMethod == null) {
      throw new IllegalArgumentException("scalingMethod cannot be null. A good default value is Method.AUTOMATIC.");
    }
    if (resizeMode == null) {
      throw new IllegalArgumentException("resizeMode cannot be null. A good default value is Mode.AUTOMATIC.");
    }

    BufferedImage result = null;

    int currentWidth = src.getWidth();
    int currentHeight = src.getHeight();

    float ratio = currentHeight / currentWidth;

    if (DEBUG) {
      log(0, "Resizing Image [size=%dx%d, resizeMode=%s, orientation=%s, ratio(H/W)=%f] to [targetSize=%dx%d]", new Object[] { Integer.valueOf(currentWidth), Integer.valueOf(currentHeight), resizeMode, ratio <= 1.0F ? "Landscape/Square" : "Portrait", Float.valueOf(ratio), Integer.valueOf(targetWidth), Integer.valueOf(targetHeight) });
    }

//    if (resizeMode != Mode.FIT_EXACT) {
//      if (((ratio <= 1.0F) && (resizeMode == Mode.AUTOMATIC)) || (resizeMode == Mode.FIT_TO_WIDTH))
//      {
//        if (targetWidth == src.getWidth()) {
//          return src;
//        }
//
//        int originalTargetHeight = targetHeight;
//
//        targetHeight = Math.round(targetWidth * ratio);
//
//        if ((DEBUG) && (originalTargetHeight != targetHeight)) {
//          log(1, "Auto-Corrected targetHeight [from=%d to=%d] to honor image proportions.", new Object[] { Integer.valueOf(originalTargetHeight), Integer.valueOf(targetHeight) });
//        }
//      }
//      else
//      {
//        if (targetHeight == src.getHeight()) {
//          return src;
//        }
//
//        int originalTargetWidth = targetWidth;
//
//        targetWidth = Math.round(targetHeight / ratio);
//
//        if ((DEBUG) && (originalTargetWidth != targetWidth)) {
//          log(1, "Auto-Corrected targetWidth [from=%d to=%d] to honor image proportions.", new Object[] { Integer.valueOf(originalTargetWidth), Integer.valueOf(targetWidth) });
//        }
//      }
//
//    }
//    else if (DEBUG) {
//      log(1, "Resize Mode FIT_EXACT used, no width/height checking or re-calculation will be done.", new Object[0]);
//    }

    if (scalingMethod == Method.AUTOMATIC) {
      scalingMethod = determineScalingMethod(targetWidth, targetHeight, ratio);
    }

    if (DEBUG) {
      log(1, "Using Scaling Method: %s", new Object[] { scalingMethod });
    }

    if (scalingMethod == Method.SPEED) {
      result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    }
    else if (scalingMethod == Method.BALANCED) {
      result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }
    else if ((scalingMethod == Method.QUALITY) || (scalingMethod == Method.ULTRA_QUALITY))
    {
      if ((targetWidth > currentWidth) || (targetHeight > currentHeight)) {
        if (DEBUG) {
          log(1, "QUALITY scale-up, a single BICUBIC scale operation will be used...", new Object[0]);
        }

        result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      }
      else {
        if (DEBUG) {
          log(1, "QUALITY scale-down, incremental scaling will be used...", new Object[0]);
        }

        result = scaleImageIncrementally(src, targetWidth, targetHeight, scalingMethod, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      }

    }

    if (DEBUG) {
      log(0, "Resized Image in %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - t) });
    }

    if ((ops != null) && (ops.length > 0)) {
      result = apply(result, ops);
    }
    return result;
  }


  protected static void log(int depth, String message, Object[] params)
  {
    if (DEBUG) {
    	Logeable.LOG_SICV2.info(LOG_PREFIX);

      for (int i = 0; i < depth; i++) {
    	  Logeable.LOG_SICV2.info("\t");
      }
      Logeable.LOG_SICV2.info(message, params);
      //Logeable.LOG_SICV2.info();
    }
  }

  protected static BufferedImage createOptimalImage(BufferedImage src)
  {
    return createOptimalImage(src, src.getWidth(), src.getHeight());
  }

  protected static BufferedImage createOptimalImage(BufferedImage src, int width, int height)
    throws IllegalArgumentException
  {
    if ((width < 0) || (height < 0)) {
      throw new IllegalArgumentException("width [" + width + "] and height [" + height + "] must be >= 0");
    }

    return new BufferedImage(width, height, src.getTransparency() == 1 ? 1 : 2);
  }

  protected static BufferedImage copyToOptimalImage(BufferedImage src)
    throws IllegalArgumentException
  {
    if (src == null) {
      throw new IllegalArgumentException("src cannot be null");
    }

    int type = src.getTransparency() == 1 ? 1 : 2;

    BufferedImage result = new BufferedImage(src.getWidth(), src.getHeight(), type);

    Graphics g = result.getGraphics();
    g.drawImage(src, 0, 0, null);
    g.dispose();

    return result;
  }

  protected static Method determineScalingMethod(int targetWidth, int targetHeight, float ratio)
  {
    int length = ratio <= 1.0F ? targetWidth : targetHeight;

    Method result = Method.SPEED;

    if (length <= 800)
      result = Method.QUALITY;
    else if (length <= 1600) {
      result = Method.BALANCED;
    }
    if (DEBUG) {
      log(2, "AUTOMATIC scaling method selected: %s", new Object[] { result.name() });
    }
    return result;
  }

  protected static BufferedImage scaleImage(BufferedImage src, int targetWidth, int targetHeight, Object interpolationHintValue)
  {
    BufferedImage result = createOptimalImage(src, targetWidth, targetHeight);

    Graphics2D resultGraphics = result.createGraphics();

    resultGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolationHintValue);

    resultGraphics.drawImage(src, 0, 0, targetWidth, targetHeight, null);

    resultGraphics.dispose();

    return result;
  }

  protected static BufferedImage scaleImageIncrementally(BufferedImage src, int targetWidth, int targetHeight, Method scalingMethod, Object interpolationHintValue)
  {
    boolean hasReassignedSrc = false;
    int incrementCount = 0;
    int currentWidth = src.getWidth();
    int currentHeight = src.getHeight();

    int fraction = scalingMethod == Method.ULTRA_QUALITY ? 7 : 2;
    do
    {
      int prevCurrentWidth = currentWidth;
      int prevCurrentHeight = currentHeight;

      if (currentWidth > targetWidth) {
        currentWidth -= currentWidth / fraction;

        if (currentWidth < targetWidth) {
          currentWidth = targetWidth;
        }

      }

      if (currentHeight > targetHeight) {
        currentHeight -= currentHeight / fraction;

        if (currentHeight < targetHeight) {
          currentHeight = targetHeight;
        }

      }

      if ((prevCurrentWidth == currentWidth) && (prevCurrentHeight == currentHeight))
      {
        break;
      }
      if (DEBUG) {
        log(2, "Scaling from [%d x %d] to [%d x %d]", new Object[] { Integer.valueOf(prevCurrentWidth), Integer.valueOf(prevCurrentHeight), Integer.valueOf(currentWidth), Integer.valueOf(currentHeight) });
      }

      BufferedImage incrementalImage = scaleImage(src, currentWidth, currentHeight, interpolationHintValue);

      if (hasReassignedSrc) {
        src.flush();
      }

      src = incrementalImage;

      hasReassignedSrc = true;

      incrementCount++;
    }while ((currentWidth != targetWidth) || (currentHeight != targetHeight));

    if (DEBUG) {
      log(2, "Incrementally Scaled Image in %d steps.", new Object[] { Integer.valueOf(incrementCount) });
    }

    return src;
  }

  static
  {
    log(0, "Debug output ENABLED", new Object[0]);
  }

  public static enum Rotation
  {
    CW_90, 

    CW_180, 

    CW_270, 

    FLIP_HORZ, 

    FLIP_VERT;
  }

  public static enum Mode
  {
    AUTOMATIC, 

    FIT_EXACT, 

    FIT_TO_WIDTH, 

    FIT_TO_HEIGHT;
  }

  public static enum Method
  {
    AUTOMATIC, 

    SPEED, 

    BALANCED, 

    QUALITY, 

    ULTRA_QUALITY;
  }
}