package ptithcm.dao;


import java.util.List;

import ptithcm.entity.Color;

public interface ColorDao {
	public List<Color> getAllColors();
	public Color getColorByName(String name);
	public Integer insertColor(Color color);
}
