// this is an abstract class to model every box
public abstract class BoxModel {
private int width; // width of the box
private int height; // height of the box
private int length; // length of the box
private int grade; // grade of the box
private int boxColour; // color either, 0, 1 or 2
private boolean sealed, bottom, corner; // to check if the box is sealed, has reinforced corners or bottoms
protected double cost; // cost of the box
private int area; // area of the box 2*(height * width) + 2*(height * length) + 2 * (width * length);
private int extraCost; // extra cost if any extra options added, sealed etc
protected int type; // type of the box
private double price; // price of the box , depends on grade

public BoxModel(int width, int height, int length, int grade,int boxColour, boolean sealed, boolean bottom, boolean corner)
{
	this.width = width;
	this.height = height;
	this.length = length;
	this.grade = grade;
	this.boxColour = boxColour;
	this.sealed = sealed;
	this.bottom = bottom;
	this.corner = corner;
	setCost(0); 
	setPrice(0);
}

/***
 * method to calculate the area of the given boxes length, width and height
 * @return
 */
public int calculateArea(){
	area = 2*(height * width) + 2*(height * length) + 2 * (width * length);
	return area;
}


/***
 * method to calculate the cost of the chosen box
 */
public void calculateCost(){
	cost = calculateArea() * gradeCost(); // sets the current cost to be equal to area * price
	cost += cost / 100 * extraCost(); // adds any extra cost to the cost variable
	cost = cost / 100;
	System.out.println(extraCost);
}

/***
 * returns the type of the box
 * @return
 */
public int getType() {
	return type;
}

/***
 * sets the type of the box
 * @param type
 */
public void setType(int type) {
	this.type = type;
}

/***
 * returns the price of the box
 * @return
 */
public double getPrice() {
	return price;
}

/***
 * sets the price of the box
 * @param price
 */
public void setPrice(double price) {
	this.price = price;
}


/***
 * sets the cost of the box
 * @param cost
 */
public void setCost(double cost) {
	this.cost = cost;
}

/***
 * returns the cost of the box
 * @return 
 */
public double getCost() {
	return cost;
}

/***
 * returns the width of the box
 * @return
 */
public int getWidth() {
	return width;
}

/***
 * sets the width of the box
 * @param width
 */
public void setWidth(int width) {
	this.width = width;
}

/***
 * returns the height of the box
 * @return
 */
public int getHeight() {
	return height;
}

/***
 * returns the length of the box
 * @return
 */
public int getLength() {
	return length;
}

/***
 * returns the grade of the box
 * @return
 */
public int getGrade() {
	return grade;
}

/***
 * returns the colour of the box
 * @return
 */
public int getBoxColour() {
	return boxColour;
}

/***
 * returns the true if the box is sealed else false
 * @return
 */
public boolean isSealed() {
	return sealed;
}

/***
 * returns true if the bottom of the box is reinforced
 * @return
 */
public boolean isBottom() {
	return bottom;
}

/***
 * returns the true if the corners of the box are reinforced
 * @return
 */
public boolean isCorner() {
	return corner;
}

/***
 * returns the type of the box
 * @return
 */
public int getBoxType()
{
	return type;
}


/***
 * returns extraCost if there is any
 * @return
 */
public int extraCost()
{
	if(getBoxType() == 1)
	{
		extraCost = 0;
	}
	if(getBoxType() == 2)
	{
		extraCost = 8;
		
	}
	if(getBoxType() == 3)
	{
		extraCost = 16;
	}
	
	if(getBoxType() == 4)
	{
		extraCost = 30;
	}
	
	if(getBoxType() == 5)
	{
		extraCost = 40;
	}
	
	if(isSealed())
	{
		extraCost += 8;
	}
	
	return extraCost;
	
}

/***
 * returns the price per box, depending on chosen grade
 * @return
 */
public double gradeCost()
	{
		if(getGrade() == 1)
		{
			price = 0.50;
		}
		if(getGrade() == 2)
		{
			price = 0.60;
		}
		if(getGrade() == 3)
		{
			price = 0.72;
		}
		if(getGrade() == 4)
		{
			price = 0.90;
		}
		if(getGrade() == 5)
		{
			price = 1.40;
		}
		return price;
	}
}
