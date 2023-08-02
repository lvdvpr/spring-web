package com.sample.web.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component   // 스프링의 빈으로 자동 등록 되게 함
public class FileDownloadView extends AbstractView {    // View라는 인터페이스를 직접구현해도 되지만 보통은 AbstractView라는 추상클래스를 상속받아 구현한다.

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		File file = (File) model.get("file");
		
		// application/octet-stream - 일반적인 바이너리 데이터에 대한 컨텐츠 타입이다. (메모장으로 읽어들일 수 없는 파일)
		setContentType("application/octet-stream");
		// 응답메세지의 헤더부에 다운로드되는 첨부파일을 이름으로 설정한다.
		// attachment; 는 브라우저에서 파일을 열지 않고, 항상 다운로드되게 한다.
		// URLEncoder.encode(text,encoding)은 텍스트를 지정된 인코딩 방식으로 변환시킨다.
		// 텍스트에 한글이 포함되어 있는 경우 utf-8방식으로 인코딩(변환)하지 않으면 한글이 전부 깨진다.
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), "utf-8"));
		
		// 파일을 읽어오는 입력스트림 객체를 생성한다.
		InputStream in = new FileInputStream(file);
		// 브라우저와 연결된 출력스트림을 획득한다.
		OutputStream out = response.getOutputStream();
		
		// 입력스트림으로 읽은 데이터를 출력스트림으로 복사해서 출력시킨다.
		IOUtils.copy(in, out);
	}
}
