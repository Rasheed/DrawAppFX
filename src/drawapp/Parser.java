package drawapp;

import drawapp.ImagePanel;
import drawapp.MainWindow;
import drawapp.ParseException;
import drawapp.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Parser
{
  private BufferedReader reader;
  private ImagePanel image;
  private MainWindow frame;
  private int i=0;

  public Parser(Reader reader, ImagePanel image, MainWindow frame)
  {
    this.reader = new BufferedReader(reader);
    this.image = image;
    this.frame = frame;
  }

  /*public void parse()
  {
    try
    {
      int count=0;
      String line = reader.readLine();
      while (line != null)
      { 
        parseLine(line);
        line = reader.readLine();
      }
    }
    catch (IOException e)
    {
      frame.postMessage("Parse failed.");
      return;
    }
    catch (ParseException e)
    {
      frame.postMessage("Parse Exception: " + e.getMessage());
      return;
    }
    ParseButton(this.reader,line);
    frame.postMessage("Drawing completed");
  }*/

  private void parseLine(String line) throws ParseException
  {
    if (line.length() < 2) return;
    String command = line.substring(0, 2);
    if (command.equals("DL")) { drawLine(line.substring(2,line.length())); return; }
    if (command.equals("DR")) { drawRect(line.substring(2, line.length())); return; }
    if (command.equals("FR")) { fillRect(line.substring(2, line.length())); return; }
    if (command.equals("SC")) { setColour(line.substring(3, line.length())); return; }
    if (command.equals("DS")) { drawString(line.substring(3, line.length())); return; }
    if (command.equals("DA")) { drawArc(line.substring(2, line.length())); return; }
    if (command.equals("DO")) { drawOval(line.substring(2, line.length())); return; }
    if (command.equals("SG")) { setGradient(line.substring(2, line.length())); return;}
    if (command.equals("DI")) { drawImage(line.substring(3, line.length())); return; 
    }

    throw new ParseException("Unknown drawing command");
  }
  
  private void drawImage(String args) throws ParseException
  {
    int x = -1;
    int y = -1 ;
    int width=-1;
    int height=-1;
    String s = "";
    StringTokenizer tokenizer = new StringTokenizer(args);
    x = getInteger(tokenizer);
    y = getInteger(tokenizer);
    width=getInteger(tokenizer);
    height=getInteger(tokenizer);
    if ((x < 0)||(y < 0)) throw new ParseException("Invalid values for Draw Image coommand");
    int position = args.indexOf("@");
    if (position == -1) throw new ParseException("DrawString string is missing");
    s = args.substring(position+1,args.length());
    System.out.println(s);
    image.drawImage(x,y,width,height,s);
  }

  private void drawLine(String args) throws ParseException
  {
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;

    StringTokenizer tokenizer = new StringTokenizer(args);
    x1 = getInteger(tokenizer);
    y1 = getInteger(tokenizer);
    x2 = getInteger(tokenizer);
    y2 = getInteger(tokenizer);
    if ((x1 < 0)||(y1 < 0)||(x2 < 0)||(y2 < 0)) throw new ParseException("Invalid values for Line command");
    image.drawLine(x1,y1,x2,y2);
  }

  private void drawRect(String args) throws ParseException
  {
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;
    
    StringTokenizer tokenizer = new StringTokenizer(args);
    x1 = getInteger(tokenizer);
    y1 = getInteger(tokenizer);
    x2 = getInteger(tokenizer);
    y2 = getInteger(tokenizer);
    if ((x1 < 0)||(y1 < 0)||(x2 < 0)||(y2 < 0)) throw new ParseException("Invalid values for Rectangle command");
    image.drawRect(x1, y1, x2, y2);
  }

  private void fillRect(String args) throws ParseException
  {
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;

    StringTokenizer tokenizer = new StringTokenizer(args);
    x1 = getInteger(tokenizer);
    y1 = getInteger(tokenizer);
    x2 = getInteger(tokenizer);
    y2 = getInteger(tokenizer);
    if ((x1 < 0)||(y1 < 0)||(x2 < 0)||(y2 < 0)) throw new ParseException("Invalid values for Fill Rectangle coommand");
    image.fillRect(x1, y1, x2, y2);
  }

  private void drawArc(String args) throws ParseException
  {
    int x = -1;
    int y = -1;
    int width = -1;
    int height = -1;
    int startAngle = -1;
    int arcAngle = -1;

    StringTokenizer tokenizer = new StringTokenizer(args);
    x = getInteger(tokenizer);
    y = getInteger(tokenizer);
    width = getInteger(tokenizer);
    height = getInteger(tokenizer);
    startAngle = getInteger(tokenizer);
    arcAngle = getInteger(tokenizer);
    if ((x < 0)||(y < 0)||(width < 0)||(height < 0)||(startAngle < 0)||(arcAngle < 0)) throw new ParseException("Invalid values for Draw Arc coommand");
    image.drawArc(x, y, width, height, startAngle, arcAngle);
  }

  private void drawOval(String args) throws ParseException
  {
    int x1 = -1;
    int y1 = -1;
    int width = -1;
    int height = -1;
    
    StringTokenizer tokenizer = new StringTokenizer(args);
    x1 = getInteger(tokenizer);
    y1 = getInteger(tokenizer);
    width = getInteger(tokenizer);
    height = getInteger(tokenizer);
    if ((x1 < 0)||(y1 < 0)||(width < 0)||(height < 0)) throw new ParseException("Invalid values for Draw Oval coommand");
    image.drawOval(x1, y1, width, height);
  }

  private void drawString(String args) throws ParseException
  {
    int x = -1;
    int y = -1 ;
    String s = "";
    StringTokenizer tokenizer = new StringTokenizer(args);
    x = getInteger(tokenizer);
    y = getInteger(tokenizer);
    if ((x < 0)||(y < 0)) throw new ParseException("Invalid values for Draw Oval coommand");
    int position = args.indexOf("@");
    if (position == -1) throw new ParseException("DrawString string is missing");
    s = args.substring(position+1,args.length());
    image.drawString(x,y,s);
  }

  private void setGradient(String args) throws ParseException
  {
     StringTokenizer tokenizer = new StringTokenizer(args);
     String S = getString(tokenizer);
     String E = getString(tokenizer);
     Color start = getColour(S);
     Color end= getColour(E);
     image.setGradient(start, end);
     System.out.println(S+E);
  }
  
  private Color getColour(String colourName) throws ParseException
  {
    if (colourName.equals("black")) { return (Color.BLACK); }
    if (colourName.equals("blue")) { return (Color.BLUE); }
    if (colourName.equals("cyan")) { return(Color.CYAN);}
    if (colourName.equals("darkgray")) { return(Color.DARKGRAY);}
    if (colourName.equals("gray")) { return(Color.GRAY);}
    if (colourName.equals("green")) { return(Color.GREEN);}
    if (colourName.equals("lightgray")) { return(Color.LIGHTGRAY);}
    if (colourName.equals("magenta")) { return(Color.MAGENTA);}
    if (colourName.equals("orange")) { return(Color.ORANGE);}
    if (colourName.equals("pink")) { return(Color.PINK);}
    if (colourName.equals("red")) { return(Color.RED);}
    if (colourName.equals("white")) { return(Color.WHITE);}
    if (colourName.equals("yellow")) { return(Color.YELLOW);}
    throw new ParseException("Invalid colour name");
  }
  
  private void setColour(String colourName) throws ParseException
  {
    if (colourName.equals("black")) { image.setColour(Color.BLACK); return;}
    if (colourName.equals("blue")) { image.setColour(Color.BLUE); return;}
    if (colourName.equals("cyan")) { image.setColour(Color.CYAN); return;}
    if (colourName.equals("darkgray")) { image.setColour(Color.DARKGRAY); return;}
    if (colourName.equals("gray")) { image.setColour(Color.GRAY); return;}
    if (colourName.equals("green")) { image.setColour(Color.GREEN); return;}
    if (colourName.equals("lightgray")) { image.setColour(Color.LIGHTGRAY); return;}
    if (colourName.equals("magenta")) { image.setColour(Color.MAGENTA); return;}
    if (colourName.equals("orange")) { image.setColour(Color.ORANGE); return;}
    if (colourName.equals("pink")) { image.setColour(Color.PINK); return;}
    if (colourName.equals("red")) { image.setColour(Color.RED); return;}
    if (colourName.equals("white")) { image.setColour(Color.WHITE); return;}
    if (colourName.equals("yellow")) { image.setColour(Color.YELLOW); return;}
    throw new ParseException("Invalid colour name");
  }
  
  private int getInteger(StringTokenizer tokenizer) throws ParseException
  {
    if (tokenizer.hasMoreTokens())
      return Integer.parseInt(tokenizer.nextToken());
    else
      throw new ParseException("Missing Integer value");
  }
  
  private String getString(StringTokenizer tokenizer) throws ParseException
  {
    if (tokenizer.hasMoreTokens())
      return tokenizer.nextToken();
    else
      throw new ParseException("Missing String value");
  }

   public void parseWithButtons(final Button b,final Button complete) throws IOException 
    {
        frame.postMessage("Press Next to draw image step by step or Complete to draw the complete image");
        String line = reader.readLine();
        final ArrayList<String> asl=new ArrayList<String>();
        while (line != null)
        { 
         asl.add(line);
         line = reader.readLine();
        }
        b.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                try 
                {
                    frame.postMessage("Press Next to continue to draw image");
                    parseLine(asl.get(i));
                    i++;
                    if(i==asl.size())
                    {
                        frame.postMessage("Drawing completed");
                        b.setDisable(true);                
                    }                 
                } catch (ParseException ex) { 
                    Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                }        
            }
        });
         complete.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                try 
                {
                    for(String line:asl)
                    {
                      parseLine(line);
                    }
                    frame.postMessage("Drawing completed");
                    b.setDisable(true);
                    complete.setDisable(true);                
                } catch (ParseException ex) { 
                    Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                }        
            }
        });
    }
}
