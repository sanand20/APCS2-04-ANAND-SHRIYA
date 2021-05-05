public class Cow {
  float x, y, dx, dy, radius;
  color c;
  color orig;
  boolean colliding, selected;
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));
    orig = c;

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
    
    if (selected){
       fill(c+99999);
       ellipse(x-radius*0.5, y-radius*0.25, radius*0.5, radius*0.5);
       ellipse(x+radius*0.5, y-radius*0.25, radius*0.5, radius*0.5);
       
       fill(255, 255, 255);
       ellipse(x-radius*0.4, y-radius*0.3, radius*0.3, radius*0.3);
       ellipse(x+radius*0.4, y-radius*0.3, radius*0.3, radius*0.3);

       
       stroke(0);
       strokeWeight(3);
       arc(x, y, radius*.75, radius * .3, 0, PI+QUARTER_PI, CHORD);
       noStroke();
       
       fill (255, 255, 255, 80);
       rect(x, y, 80, 50);
       fill(0, 0, 0);
       text(dx, x+5, y+20);
       text(dy, x+5, y+40);
      }
      if (colliding){
        c = color(255, 0, 0, 50); 
     }
     else{
       c = orig;
     }
     colliding = false;
    
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
   if (dist(mouseX,mouseY,x, y)<=radius){
     selected = true;
     println("hi");
   }
    
  }
  void collide(ArrayList<Cow>others){
    for (int i = 0; i<others.size(); i++){
      if (dist(others.get(i).x, others.get(i).y, x, y)<= others.get(i).radius && dist(others.get(i).x, others.get(i).y, x, y) != 0){
      others.get(i).colliding = true;
      colliding = true;
      }
    }
  }


}
