package 面经.OOD.Question8_3;

import java.util.Queue;

public class Playlist {
	private Song song;
	//如果只是list的话，不太好操作，queue是一个很好的选择
	//而且可以考虑看queue的开头，FIFO
	private Queue<Song> queue;

	public Playlist(Song song, Queue<Song> queue) {
		super();
		this.song = song;
		this.queue = queue;
	}
	
	public Song getNextSongToPlay(){ return queue.peek(); }
	public void queueUpSong(Song s){ queue.add(s); }
}

