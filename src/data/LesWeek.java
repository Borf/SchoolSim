package data;

import java.util.ArrayList;

public class LesWeek {
	public ArrayList<LesDag> dagen = new ArrayList<>();
	
	public LesWeek() {
		dagen.add(new LesDag(LesDag.Dag.Maandag));
		dagen.add(new LesDag(LesDag.Dag.Dinsdag));
		dagen.add(new LesDag(LesDag.Dag.Woensdag));
		dagen.add(new LesDag(LesDag.Dag.Donderdag));
		dagen.add(new LesDag(LesDag.Dag.Vrijdag));
	}

	public int zoekDagVoorLes(Les les) {
		for(int i = 0; i < 5; i++)
		{
			if(dagen.get(i).lessen.contains(les))
				return i;
		}
		return -1;
	}
}
