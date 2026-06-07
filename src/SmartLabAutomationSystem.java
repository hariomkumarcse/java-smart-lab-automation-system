abstract class ElectricAppliance
{
	String company;
	int powerConsumption;
	boolean isStatus;
	
	ElectricAppliance(String company, int powerConsumption, boolean isStatus)
	{
		this.company = company;
		this.powerConsumption = powerConsumption;
		this.isStatus = isStatus;
	}
	int getPowerConsumption()
	{
		return powerConsumption;
	}
	String getCompany()
	{
		return company;
	}
	String getIsStatus()
	{
		return (isStatus==true?"ON":"OFF");
	}
	void setIsStatus(boolean isStatus)
	{
		this.isStatus = isStatus;
	}
	abstract void turnOn();
	abstract void turnOff();

	public String toString()
	{
		return "Company: " +company+ " , Power Consumption: " +powerConsumption+" , Status: " +isStatus;
	}
	abstract void performPrimaryFunction();
}
class Fan extends ElectricAppliance
{
	int speed;
	int noOfWings;

	Fan(String company, int powerConsumption,boolean isStatus, int speed, int noOfWings)
	{
		super(company,powerConsumption,isStatus);
		this.speed = speed;
		this.noOfWings = noOfWings;
	}
	void turnOn()
	{
		setIsStatus(true);
		System.out.println("Fan is turned on.");
		performPrimaryFunction();
	}
	void turnOff()
	{
		setIsStatus(false);
		System.out.println("Fan is turned off.");
	}
	public String toString()
	{
		return "Fan Company: " +company+ " , Power Consumption: " +powerConsumption+ " , Status: " +isStatus+ " , Speed: " +speed+ " , No. Of Wings: " +noOfWings ;
	}
	void performPrimaryFunction()
	{
		System.out.println("Fan is giving air");
	}
}
class TubeLight extends ElectricAppliance
{
	int brightness;
	
	TubeLight(String company, int powerConsumption,boolean isStatus, int brightness)
	{
		super(company,powerConsumption,isStatus);
		this.brightness = brightness;
	}
	void turnOn()
	{
		setIsStatus(true);
		System.out.println("Tube Light is turned on.");
		performPrimaryFunction();
	}
	void turnOff()
	{
		setIsStatus(false);
		System.out.println("Tube Light is turned off.");
	}
	void performPrimaryFunction()
	{
		System.out.println("Tube Light is giving light");
	}
	public String toString()
	{
		return "Tube Light Company: " +company+ " , Power Consumption: " +powerConsumption+ " , Status: " +isStatus+ " , Brightness: " +brightness;
	}
}
class AC extends ElectricAppliance implements RemoteControllable
{
	int temperature;

	AC(String company, int powerConsumption,boolean isStatus, int temperature)
	{
		super(company,powerConsumption,isStatus);
		this.temperature = temperature;
	}
	void turnOn()
	{
		System.out.println("AC is turned on.");
		performPrimaryFunction();
	}
	void turnOff()
	{
		System.out.println("AC is turned off.");
	}
	void performPrimaryFunction()
	{
		System.out.println("AC is cooling the laboratory");
	}
	public void connectRemote(RemoteControl remote)
	{
		remote.setElectricAppliance(this);

	}
	public String toString()
	{
		return "AC Company: " +company+ " , Power Consumption: " +powerConsumption+ " , Status: " +isStatus+ " , temperature: " +temperature;
	}
}
class Projector extends ElectricAppliance implements RemoteControllable
{
	String resolution;

	String getResolution()
	{
		return resolution;
	}
	Projector(String company, int powerConsumption, boolean isStatus,String resolution)
	{
		super(company,powerConsumption,isStatus);
		this.resolution = resolution;
	}
	void turnOn()
	{
		System.out.println("Projector is turned on.");
		performPrimaryFunction();
	}
	void turnOff()
	{
		System.out.println("Projector is turned off.");
	}
	void performPrimaryFunction()
	{
		System.out.println("Projector Display Presentations");
	}
	public void connectRemote(RemoteControl remote)
	{
		remote.setElectricAppliance(this);
	}
	public String toString()
	{
		return "Projector Company: " +company+ " , Power Consumption: " +powerConsumption+ " , Status: "+isStatus+" , Resolution: " +resolution;
	}
}
interface RemoteControllable
{
	void connectRemote(RemoteControl remote);
}
class RemoteControl
{
	String brand;
	double batteryPercentage;
	
	ElectricAppliance appliance;

	void setElectricAppliance(ElectricAppliance appliance)
	{
		this.appliance = appliance;
	}

	ElectricAppliance getElectricAppliance()
	{
		return appliance;
	}
	RemoteControl(String brand, double batteryPercentage)
	{
		this.brand = brand;
		this.batteryPercentage = batteryPercentage;
	}

	void showBatteryStatus()
	{
		System.out.println("Battery Status: " + batteryPercentage);		
	}
	void turnOn()
	{
		appliance.setIsStatus(true);
		appliance.turnOn();
	}
	void turnOff()
	{
		appliance.setIsStatus(false);
		appliance.turnOff();
	}
}
class SmartLabAutomationSystem
{
	public static void main(String[] args)
	{
	
		System.out.println("\n----------AC----------\n");

		AC ac1 = new AC("Samsung",2000,false,21);
		System.out.println(ac1);
		RemoteControl ac1Remote = new RemoteControl("Samsung",50);

		ac1.connectRemote(ac1Remote);
		ac1Remote.turnOn();
		System.out.println(ac1);

		ac1Remote.turnOff();
		System.out.println(ac1);

		System.out.println("\n----------Projector----------\n");
		Projector projector1 = new Projector("Samsung",50,false,"80");
		System.out.println(projector1);

		RemoteControl projector1Remote = new RemoteControl("LG",100);
		projector1.connectRemote(projector1Remote);
		projector1Remote.turnOn();
		System.out.println(projector1);
		
		projector1Remote.turnOff();
		System.out.println(projector1);

		System.out.println("\n----------Fan----------\n");

		Fan fan1 = new Fan("USHA", 100,false,5,3);
		System.out.println(fan1);
		fan1.turnOn();
		System.out.println(fan1);
		fan1.turnOff();
		System.out.println(fan1);

		System.out.println("\n----------Tube Light----------\n");

		TubeLight light1 = new TubeLight("GrateWhite",50,false,100);
		System.out.println(light1);
		light1.turnOn();
		System.out.println(light1);
		light1.turnOff();
		System.out.println(light1);
	}
}