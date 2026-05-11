package com.aladdin.common.security.captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图形验证码生成器
 *
 * @author cles
 * @date 2026/05/06
 */
public class CaptchaGenerator {

    private static final String CHARACTERS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int CODE_LENGTH = 4;
    private static final int LINE_COUNT = 6;

    public static CaptchaResult generate() {
        Random random = new Random();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            String ch = String.valueOf(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            code.append(ch);
            g.setColor(new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150)));
            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 28));
            g.drawString(ch, 20 + i * 25, 30);
        }

        for (int i = 0; i < LINE_COUNT; i++) {
            g.setColor(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200)));
            g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }

        g.dispose();
        return new CaptchaResult(code.toString(), image);
    }

    public static class CaptchaResult {
        private final String code;
        private final BufferedImage image;

        public CaptchaResult(String code, BufferedImage image) {
            this.code = code;
            this.image = image;
        }

        public String getCode() {
            return code;
        }

        public BufferedImage getImage() {
            return image;
        }
    }
}
