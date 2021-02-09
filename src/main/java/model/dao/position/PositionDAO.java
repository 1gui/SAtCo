package model.dao.position;

import java.util.List;

import model.entity.position.Position;

public interface PositionDAO {
	
	void insertPosition(Position position);
	
	void removePosition(Position position);
		
	void updatePosition(Position position);
		
	List<Position> listPosition();
}
