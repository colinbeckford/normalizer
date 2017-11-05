
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NormalizerConstructor {
	static ArrayList<NormalizerConstructor> rawPlayerInput = new ArrayList<NormalizerConstructor>();
	private String player;
	private double score;
	static ArrayList<NormalizerConstructor> scoreOutput = new ArrayList<NormalizerConstructor>();
	static DecimalFormat df = new DecimalFormat("#.#");
	
	
	public NormalizerConstructor(String Splayer, double Dscore)
	{
		player = Splayer;
		score = Dscore;
		rawPlayerInput.add(this);
		
	}
	
	public String getName()
	{
		return player;
	}
	
	public double getScore()
	{
		return score;
	}
	
	public static ArrayList finalScoreReturn()
	{
		
		Collections.sort(rawPlayerInput, (p1, p2) -> (int)p1.getScore() - (int)p2.getScore());
		Collections.reverse(rawPlayerInput);
		return rawPlayerInput;
	}
	
	public static ArrayList scoreNormalizer()
	{
		
		int size = rawPlayerInput.size();
		for (int i=0;i<size;i++)
		{
			double normalizedScore = (((double)rawPlayerInput.get(i).getScore()/rawPlayerInput.get(0).getScore())*60);
			double roundedScore = Double.parseDouble(df.format(normalizedScore));
			scoreOutput.add(new NormalizerConstructor(rawPlayerInput.get(i).getName(), roundedScore));
		}
		return scoreOutput;
	}
	
	
}
