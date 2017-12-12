package 面经.OOD.Question8_3;

public class CDPlayer {
	//field的类别也是class

	//依据这个选择
	private Playlist p;
	//可以装歌的
	private CD c;

	//为filed提供getter和setter
	public Playlist getPlaylist() { return p; }
	public void setPlaylist(Playlist p) { this.p = p; }
	public CD getCD() { return c; }
	public void setCD(CD c) { this.c = c; }

	//可以去overload你的constructor
	public CDPlayer(Playlist p) { this.p = p; }
	public CDPlayer(CD c, Playlist p) { 
		this.p = p;
		this.c = c;
	}

	public CDPlayer(CD c){ this.c = c; }

	//动作，播放一个特定的歌曲，接收歌曲，产出void
	//method的input和output
	public void playSong(Song s) {  }
}
