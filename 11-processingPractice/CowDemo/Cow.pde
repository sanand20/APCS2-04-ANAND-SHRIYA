public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (dist(mouseX,x,mouseY,y)<=radius){
     selected = true;
     println("hi");
   }
    
  }
  void collide(ArrayList<Cow>others){
    for (int i = 0; i<others.size(); i++){
      if (dist(others.get(i).x, x, others.get(i).y, y)<=radius){
      colliding = true;
      println("yea");
      }
    }
  }


}
