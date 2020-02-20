package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.MeetingService;
import sun.misc.BASE64Encoder;
import util.QRCodeUtils;
import vo.Meeting;
import vo.User;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowQRCodeController",urlPatterns = "/showQRCode")
public class ShowQRCodeController extends HttpServlet
{

    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = request.getParameter("id");
        Meeting meeting = meetingService.findByMeetingId(id);
        BufferedImage qrCode = null;
        try {
            // 生成二维码
            qrCode = QRCodeUtils.createQRCode(user.getName().concat("join"+meeting.getName()),
                    400, 400, 10);
            // 导出到指定路径
            //boolean result = QRCodeUtils.generateQRCodeToPath(qrCode, "C:\\Users\\me\\IdeaProjects\\meeting\\web\\images", user.getId().concat(e.getId()), "jpg");
        }
        catch (Exception s) {
            s.printStackTrace();
        }
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        ImageIO.write(qrCode,"jpg",bAOS);
        byte[] bytes = bAOS.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        String json = objectMapper.writeValueAsString(png_base64);
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
