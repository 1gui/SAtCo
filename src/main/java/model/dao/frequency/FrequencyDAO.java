package model.dao.frequency;

import java.util.List;

import model.entity.frequency.Frequency;

public interface FrequencyDAO {

	void insertFrequency(Frequency frequency);

	void removeFrequency(Frequency frequency);

	void updateFrequency(Frequency frequency);

	Frequency recoverFrequency(Frequency frequency);
	
	List<Frequency> listFrequency();

}