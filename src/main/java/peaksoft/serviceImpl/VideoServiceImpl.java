package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.VideoDAO;
import peaksoft.model.Video;
import peaksoft.service.VideoService;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class VideoServiceImpl implements VideoService{
    private final VideoDAO videoDAO;

    @Autowired
    public VideoServiceImpl(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
    }

    @Override
    public void saveVideo(Video newVideo, Long lessonId) {
        videoDAO.saveVideo(newVideo,lessonId );
    }

    @Override
    public void updateVideo(Long id, Video newVideo) {
        videoDAO.updateVideo(id, newVideo);
    }

    @Override
    public void deleteVideoById(Long id) {
        videoDAO.deleteVideoById(id);
    }

    @Override
    public List<Video> getVideos(Long id) {
        return videoDAO.getVideos(id);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDAO.getVideoById(id);
    }
}
