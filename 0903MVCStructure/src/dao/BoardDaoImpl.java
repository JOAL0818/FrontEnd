package dao;

public class BoardDaoImpl implements BoardDao {
	//singleton 패턴적용 
	
	//1.생성자를 private으로 하면 다른 곳에서 new를 이용한 인스턴스 생성을 못하게 할 수 있다. 
	private BoardDaoImpl() {
		
	}
	
	//static 변수로 자신의 인스턴스를 저장할 수 있는 변수를 선언 
	private static BoardDao boardDao;
	
	//인스턴스를 생성해서 리턴해주는 static 메소드 생성 
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
}
