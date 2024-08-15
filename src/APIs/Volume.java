package APIs;

import Modelos.LivroGoogle;

public class Volume {
    private LivroGoogle volumeInfo;

    public LivroGoogle getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(LivroGoogle volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}