import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a image drawn in the Scene
 */
public class SceneImage extends Methods {

  private String fileName; // name of file
  private int x; // x location
  private int y; // y location

  public SceneImage(String fileName, int x, int y) {
    this.fileName = fileName;
    this.x = x;
    this.y = y;
  }

/**
 * returns x value of image
  */
  public int getX() {
    return x;
  }
/**
 * returns y value of image
  */
  public int getY() {
    return y;
  }

  /**
 * returns name of image/file
  */
  public String getFileName() {
    return fileName;
  }

  public void setX(int newX) {
    x = newX;
  }

  public void setY(int newY) {
    y = newY;
  }
  
  public void setFile(String newFileName) {
    fileName = newFileName;
  }

}
