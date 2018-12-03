import java.util.*; 
// Scanner , Locale


public class Temperatures {
	public static void main (String[] args) {
		System.out.println ("TEMPERATURES\n");
		// input tools
		Scanner in = new Scanner (System.in); 
		in.useLocale (Locale.US);
		// enter the number of weeks and measurements
		System.out.print ("number of weeks: ");
		
		int nofWeeks = in.nextInt ();
		System.out.print ("number of measurements per week: "); 
		
		int nofMeasurementsPerWeek = in.nextInt ();
		// storage space for temperature data
		double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];
		// read the temperatures 
		for (int week = 1; week <= nofWeeks; week++) { 
			System.out.println ("temperatures - week " + week + ":");
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				t[week][reading] = in.nextDouble (); 
			} 
		System.out.println ();
		
		// show the temperatures
		System.out.println("the temperatures:"); 
		for (int week = 1; week <= nofWeeks; week++) { 
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				System.out.print (t[week][reading] + " ");
			System.out.println ();
			}
		System.out.println ();
		
		// the least , greatest and average temperature - weekly
		double[] minT = new double[nofWeeks + 1];
		double[] maxT = new double[nofWeeks + 1];
		double[] sumT = new double[nofWeeks + 1];
		double[] avgT = new double[nofWeeks + 1];
		// compute and store the least , greatest and average 
		// temperature for each week.
		// *** WRITE YOUR CODE HERE ***
		for (int week = 1 ; week <= nofWeeks ; week++)
		{
			minT[week] = t[week][1];
			maxT[week] = t[week][1];
			sumT[week] = t[week][1];
			for(int readings = 2; readings <= nofMeasurementsPerWeek; readings++ )
			{
				sumT[week] += t[week][readings];
				if (minT[week] > t[week][readings])
					minT[week] = t[week][readings];
				if (maxT[week] < t[week][readings])
					maxT[week] = t[week][readings];
			}
			//System.out.println(sumT[week]);
			//This would print the sum for each week
			// 
			avgT[week] = sumT[week]/nofMeasurementsPerWeek;
		}
		// Due to the way the task is created, efficiency could not be held
		// One better way of solving this, is to determinate the maxT, minT and avgT while 
		// Reading the temperature input
		
		
		// show the least , greatest and average temperature for 
		// each week
		// *** WRITE YOUR CODE HERE ***
		for ( int week = 1; week <= nofWeeks; week++)
		{
			System.out.println("The temperatures for the week " + week + " are: \n" + "Minimum: "
					+ minT[week] + "\n" + "Maximum: " + maxT[week] + "\n" + "Average: " + avgT[week]);
		}

		
		
		
		// the least , greatest and average temperature - whole period 
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1]; // This is not necessary 
		double avgTemp = 0;
		
		// Was not sure I am allowed to change the code,
		// but as all are initialized with [1], it is best to do so with avg, too, in order to
		// start the loop right from index 2
		
		
		// compute and store the least , greatest and average 
		// temperature for the whole period 
		// *** WRITE YOUR CODE HERE ***
		
		for (int week = 2; week <= nofWeeks; week++)
		{
			sumTemp += sumT[week];
			if ( minTemp > minT[week] )
				minTemp = minT[week];
			if ( maxTemp < maxT[week] )
				maxTemp = maxT[week];
		}
		avgTemp = sumTemp/(nofWeeks*nofMeasurementsPerWeek);
		
		
		
		// show the least , greatest and average temperature for
		// the whole period 
		System.out.println ( " The alltime: \n Minimum is " + minTemp + "\n Maximum: " + maxTemp
				+ "\n Average is: " + avgTemp );
		
		in.close();
	}
}