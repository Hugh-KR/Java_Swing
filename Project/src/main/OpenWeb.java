package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenWeb {
	public static void ow(String adr) {
		try {
			Desktop.getDesktop().browse(new URI("mailto:" + adr));	// 브라우저 주소창에 mailto: + 넘겨받은 이메일 을 입력 - 자동으로 메일작성창 오
			System.out.println(adr);	//넘겨받은 이메일 콘솔창 확인용
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
