package 面经.OOD.Question8_3;


public class SongSelector {
	private Song currentSong;
    //constructor 和 getter & setter

	public SongSelector(Song s) { currentSong=s; }

	public void setSong(Song s) { currentSong = s;	}
	public Song getCurrentSong() { return currentSong;	}
}

