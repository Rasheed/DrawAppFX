enum colour {black,blue,cyan,darkgray,gray,green,lightgray,magenta,orange,pink,red,white,yellow};
typedef enum colour colour;

void drawLine(int,int,int,int);
void drawRect(int,int,int,int);
void drawOval(int,int,int,int);
void drawArc(int,int,int,int,int,int);
void fillRect(int,int,int,int);
void drawString(char*,int,int);
void drawImage(int,int,int,int,char*);
void drawRoundRect(int,int,int,int,int);
void fillRoundRect(int,int,int,int,int);

void setColour(colour);
void setGradient(colour,colour);
void setDimensions(int,int);

void startTurtle(int,int,int);
void forward(int);
void turnLeft(int);
void turnRight(int);
void penUp();
void penDown();