package text;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/incomeTaxCalculatorServlet")
public class IncomeTaxCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取用户输入的月收入
        System.out.println("About to forward to result.jsp");
        double monthlyIncome = Double.parseDouble(request.getParameter("monthlyIncome"));
        double numberOfChildren = Double.parseDouble(request.getParameter("children"));
        // 调用个人所得税计算方法
        double tax =calculatePersonalIncomeTax(monthlyIncome,numberOfChildren);

        // 将计算结果存储在请求属性中
        request.setAttribute("tax", tax);

        // 转发到结果页面
        System.out.println("About to forward to result.jsp");
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private double calculatePersonalIncomeTax(double income,double numberOfChildren) {
        double tax = 0;
        double taxableIncome = income - 5000; // 应纳税所得额
        // 根据新的子女教育专项附加扣除标准，计算应扣除的子女教育支出
        double childrenEducationDeduction = numberOfChildren * 2000; // 每个子女每月2000元

        // 将子女教育支出扣除后的应纳税所得额
        taxableIncome -= childrenEducationDeduction;

        if (taxableIncome <= 0) {
            tax = 0;
        } else if (taxableIncome <= 3000) {
            tax = taxableIncome * 0.03;
        } else if (taxableIncome <= 12000) {
            tax = taxableIncome * 0.1 - 210;
        } else if (taxableIncome <= 25000) {
            tax = taxableIncome * 0.2 - 1410;
        } else if (taxableIncome <= 35000) {
            tax = taxableIncome * 0.25 - 2660;
        } else if (taxableIncome <= 55000) {
            tax = taxableIncome * 0.3 - 4410;
        } else if (taxableIncome <= 80000) {
            tax = taxableIncome * 0.35 - 7160;
        } else {
            tax = taxableIncome * 0.45 - 15160;
        }

        return tax;
    }
}