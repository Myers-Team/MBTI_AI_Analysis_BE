package com.mbtiai.demo.contents;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ContentsServiceImpl implements ContentsService{
}
