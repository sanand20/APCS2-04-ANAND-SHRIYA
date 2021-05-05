ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
    c.collide(particles);
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow 
   
   if (mousePressed && (mouseButton==LEFT)){
   for (int i = 0; i<particles.size(); i++){
     particles.get(i).click();
   }
   }
   else if (mousePressed && (mouseButton==RIGHT)){
   particles.add(new Cow(20+(int)(Math.random()*30), mouseX, mouseY, 
    random(6)-3,
    random(6)-3));
   }
}

void keyPressed() {
  //Read about keyPressed() in the documentation.
  //hint:
  //println(keyCode);
  if (key == 32){
  particles.clear();
  }
  
}
