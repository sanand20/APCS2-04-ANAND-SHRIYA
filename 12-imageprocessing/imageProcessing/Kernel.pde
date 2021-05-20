public class Kernel {
  float[][]kernel;

  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
    kernel = new float [3][3];
    for (int i = 0; i<3; i++){
      for (int j = 0; j<3; j++){
        kernel[i][j] = init[i][j];
      }
    }
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
   
    return color(r,g,b);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    for (int i = 1; i<source.width; i++){
      for (int j = 1; j<source.height; j++){
        color c = calcNewColor(source, i,j);
        destination.set(i,j,c);
      }  
    }
  }

}
