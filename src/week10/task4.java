package week10;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

    class Song {
        private String title;
        private String artist;
        private String genre;

        public Song(String title, String artist, String genre) {
            this.title = title;
            this.artist = artist;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", genre='" + genre + '\'' +
                    '}';
        }
    }

    class GenreFilterIterator implements Iterator<Song> {
        private List<Song> playlist;
        private String targetGenre;
        private int currentIndex;

        public GenreFilterIterator(List<Song> playlist, String targetGenre) {
            this.playlist = playlist;
            this.targetGenre = targetGenre;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            while (currentIndex < playlist.size()) {
                if (playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more songs with the target genre");
            }
            return playlist.get(currentIndex++);
        }
    }

    class PlaylistExample {
        public static void main(String[] args) {
            // Create a playlist of songs
            List<Song> playlist = new ArrayList<>();
            playlist.add(new Song("Song1", "Artist1", "Rock"));
            playlist.add(new Song("Song2", "Artist2", "Pop"));
            playlist.add(new Song("Song3", "Artist3", "Rock"));
            playlist.add(new Song("Song4", "Artist4", "Hip Hop"));
            playlist.add(new Song("Song5", "Artist5", "Rock"));

            // Create an instance of GenreFilterIterator
            GenreFilterIterator iterator = new GenreFilterIterator(playlist, "Rock");

            // Use the iterator to print the details of songs with the target genre
            while (iterator.hasNext()) {
                Song song = iterator.next();
                System.out.println(song);
            }
        }
    }
