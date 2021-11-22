package com.example.jpa.sample1.notice.controller;

import com.example.jpa.sample1.notice.entity.Notice;
import com.example.jpa.sample1.notice.exception.NoticeNotFoundException;
import com.example.jpa.sample1.notice.model.NoticeInput;
import com.example.jpa.sample1.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ApiNoticeController {

    private final NoticeRepository noticeRepository;

    /*
    @GetMapping("/api/notice")
    public String noticeString() {
        return "공지사항입니다.";
    }
     */

    /*
    @GetMapping("/api/notice")
    public NoticeModel notice() {

        LocalDateTime regDate = LocalDateTime.of(2021, 2, 8, 0, 0);

        NoticeModel notice = new NoticeModel();
        notice.setId(1);
        notice.setTitle("공지사항입니다.");
        notice.setContents("공지사항 내용입니다.");
        notice.setRegDate(regDate);

        return notice;
    }

     */

//    @GetMapping("/api/notice")
//    public List<NoticeModel> notice() {
//
//        List<NoticeModel> noticeList = new ArrayList<>();
//
//        NoticeModel notice1 = new NoticeModel();
//        notice1.setId(1);
//        notice1.setTitle("공지사항입니다.");
//        notice1.setContents("공지사항 내용입니다.");
//        notice1.setRegDate(LocalDateTime.of(2021, 1, 30, 0, 0));
//        noticeList.add(notice1);
//
//        NoticeModel notice2 = NoticeModel.builder()
//                .id(2)
//                .title("두번째 공지사항입니다.")
//                .contents("두번째 공지사항 내용입니다.")
//                .regDate(LocalDateTime.of(2021, 1, 31, 0, 0))
//                .build();
//
//        noticeList.add(notice2);
//
//        return noticeList;
//    }

    @GetMapping("/api/notice")
    public List<NoticeInput> notice() {

        List<NoticeInput> noticeList = new ArrayList<>();

        return noticeList;
    }

    @GetMapping("/api/notice/count")
    public int noticeCount() {

        return 10;
    }

   /* @PostMapping("/api/notice")
    public NoticeModel addNotice(@RequestParam String title, @RequestParam String contents) {
        NoticeModel notice = NoticeModel.builder()
                .id(1)
                .title(title)
                .contents(contents)
                .regDate(LocalDateTime.now())
                .build();

        return notice;

    }*/

   /* @PostMapping("/api/notice")
    public NoticeModel addNotice(NoticeModel noticeModel) {

        noticeModel.setId(2);
        noticeModel.setRegDate(LocalDateTime.now());

        return noticeModel;
    }*/

    /*@PostMapping("/api/notice")
    public Notice addNotice(@RequestBody NoticeInput noticeInput) {
        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .regDate(LocalDateTime.now())
                .build();

        noticeRepository.save(notice);

        return notice;
    }*/

    /*@PostMapping("/api/notice")
    public Notice addNotice(@RequestBody NoticeInput noticeInput) {
        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .regDate(LocalDateTime.now())
                .hits(0)
                .likes(0)
                .build();

        Notice resultNotice = noticeRepository.save(notice);

        return resultNotice;
    }*/

    /*@GetMapping("/api/notice/{id}")
    public Notice notice(@PathVariable long id) {

        Optional<Notice> notice = noticeRepository.findById(id);

        return notice.orElse(null);

    }*/

    /*@PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, NoticeInput noticeInput) {

        Optional<Notice> notice = noticeRepository.findById(id);

        if (notice.isPresent()) {
            notice.get().setTitle(noticeInput.getTitle());
            notice.get().setContents(noticeInput.getContents());
            notice.get().setUpdateDate(LocalDateTime.now());

            noticeRepository.save(notice.get());
        }
    }*/

    @ExceptionHandler(NoticeNotFoundException.class)
    public ResponseEntity<String> handlerNoticeNotFoundException(NoticeNotFoundException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

    }

    /*
    @PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {

        *//*
        Optional <Notice> notice = noticeRepository.findById(id);
        if (!notice.isPresent()) {
            // 예외 발생
            throw new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다.");
        }
         *//*

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

        //공지사항 글이 있을 때
        notice.setTitle(noticeInput.getTitle());
        notice.setContents(noticeInput.getContents());
        notice.setUpdateDate(LocalDateTime.now());
        noticeRepository.save(notice);

    }
    */
    @PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));

        notice.setTitle(noticeInput.getTitle());
        notice.setContents(noticeInput.getContents());
        notice.setUpdateDate(LocalDateTime.now());
        noticeRepository.save(notice);

    }



}
