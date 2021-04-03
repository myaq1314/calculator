package com.czh.calculator.monitor.global;

import com.czh.calculator.CurrentField;
import com.czh.calculator.exceptions.CalculatorException;
import com.czh.calculator.layout.OperateJPanelFactory;
import com.czh.calculator.monitor.base.AddJButtonMonitor;
import com.czh.calculator.monitor.base.DivideJButtonMonitor;
import com.czh.calculator.monitor.base.MultiplyJButtonMonitor;
import com.czh.calculator.monitor.base.SubtractJButtonMonitor;
import com.czh.calculator.monitor.other.FactorialJButtonMonitor;
import com.czh.calculator.monitor.other.Log10JButtonMonitor;
import com.czh.calculator.monitor.other.PowerJButtonMonitor;
import com.czh.calculator.monitor.other.SignEvolutionJButtonMonitor;
import com.czh.calculator.monitor.num_constant.EJButtonMonitor;
import com.czh.calculator.monitor.num_constant.PaiJButtonMonitor;
import com.czh.calculator.monitor.overturn.NumeratorDenominatorTurnJButtonMonitor;
import com.czh.calculator.monitor.parent.JButtonMonitor;
import com.czh.calculator.monitor.other.ExactDivisionJButtonMonitor;
import com.czh.calculator.monitor.other.PrimeNumJButtonMonitor;
import com.czh.calculator.monitor.other.RemainderJButtonMonitor;
import com.czh.calculator.monitor.rate.PercentJButtonMonitor;
import com.czh.calculator.monitor.trigonometric.CosJButtonMonitor;
import com.czh.calculator.monitor.trigonometric.SinJButtonMonitor;
import com.czh.calculator.monitor.trigonometric.TanJButtonMonitor;

import javax.swing.JButton;

/**
 * @author : czh
 * @description : 操作符号 总监听器
 * @email 916419307@qq.com
 */
public class OperateSymbolJButtonMonitor implements JButtonMonitor {

    public static void setSymbol(String text) {
        switch (text) {
            case "+":
                AddJButtonMonitor.add();
                break;
            case "-":
                SubtractJButtonMonitor.subtract();
                break;
            case "×":
                MultiplyJButtonMonitor.multiply();
                break;
            case "÷":
                DivideJButtonMonitor.divide();
                break;
            case "%":
                PercentJButtonMonitor.percent();
                break;
            case "1/n":
                NumeratorDenominatorTurnJButtonMonitor.numeratorDenominatorTurn();
                break;
            case "sin":
                SinJButtonMonitor.sin();
                break;
            case "cos":
                CosJButtonMonitor.cos();
                break;
            case "tan":
                TanJButtonMonitor.tan();
                break;
            case "x!":
                FactorialJButtonMonitor.factorial();
                break;
            case "x^y":
                PowerJButtonMonitor.power();
                break;
            case "y√x":
                SignEvolutionJButtonMonitor.signEvolution();
                break;
            case "e":
                EJButtonMonitor.e();
                break;
            case "π":
                PaiJButtonMonitor.pai();
                break;
            case "整除":
                ExactDivisionJButtonMonitor.exactDivision();
                break;
            case "取余":
                RemainderJButtonMonitor.remainder();
                break;
            case "Log10":
                Log10JButtonMonitor.log10();
                break;
            case "质数":
                PrimeNumJButtonMonitor.primeNum();
                break;

        }
    }

    @Override
    public void addJButtonMonitor(JButton jButton) {
        jButton.addActionListener(e -> {
            try {
                setSymbol(e.getActionCommand());
            } catch (CalculatorException ce) {
                CurrentField.setError(ce.getInput(), ce.getShow());
            }
            OperateJPanelFactory.startCCleanJButton();
        });
    }
}
