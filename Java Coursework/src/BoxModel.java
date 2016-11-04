
public abstract class BoxModel {
private int width;
private int height;
private int length;
private int grade;
private int boxColour;
private boolean sealed, bottom, corner;
protected double cost;
private int area;
private int extraCost;
protected int type;
private double price;

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
	cost = 0;
	price = 0;
}

public int calculateArea()
{
	area = 2*(height * width) + 2*(height * length) + 2 * (width * length);
	return area;
}



public void calculateCost()
{
	cost = calculateArea() * gradeCost();
	cost += cost / 100 * extraCost();
}

public double getCost() {
	return cost;
}


public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getBoxColour() {
	return boxColour;
}
public void setBoxColour(int boxColour) {
	this.boxColour = boxColour;
}
public boolean isSealed() {
	return sealed;
}
public void setSealed(boolean sealable) {
	this.sealed = sealable;
}
public boolean isBottom() {
	return bottom;
}
public void setBottom(boolean bottom) {
	this.bottom = bottom;
}
public boolean isCorner() {
	return corner;
}
public void setCorner(boolean corner) {
	this.corner = corner;
}

public int getBoxType()
{
	return type;
}



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
		extraCost = 22;
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
