package com.ekh.basiccalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {
    private lateinit var lastOperation: TextView
    private lateinit var expression: TextView
    private lateinit var result: TextView
    private lateinit var clear: Button
    private lateinit var equal: Button
    private lateinit var multiply: Button
    private lateinit var add: Button
    private lateinit var divide: Button
    private lateinit var backspace: Button
    private lateinit var subtract: Button
    private lateinit var zero: Button
    private lateinit var dot: Button
    private lateinit var doublezero: Button
    private lateinit var percent: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lastOperation = findViewById(R.id.lastOperation)
        expression= findViewById(R.id.expression)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        equal = findViewById(R.id.equals)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.plus)
        divide = findViewById(R.id.divide)
        backspace= findViewById(R.id.backSpace)
        subtract= findViewById(R.id.subtract)
        zero= findViewById(R.id.zero)
        dot = findViewById(R.id.dot)
        doublezero = findViewById(R.id.doubleZero)
        percent= findViewById(R.id.modulo)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three= findViewById(R.id.three)
        four= findViewById(R.id.four)
        five= findViewById(R.id.five)
        six= findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight= findViewById(R.id.eight)
        nine= findViewById(R.id.nine)
        expression.movementMethod= ScrollingMovementMethod()
        expression.isActivated=true
        expression.isPressed=true
        var tempStr: String
        clear.setOnClickListener(){
            expression.text="0"
            expression.textSize = 60F
            result.textSize= 30F
            resultText()

        }
        equal.setOnClickListener(){
            lastOperation.text= expression.text.toString()
            expression.text= result.text.toString()
            expression.textSize= 30F
            result.textSize=60F

        }

        multiply.setOnClickListener(){
            var expressionString = expression.text.toString()
            expression.textSize = 60F
            result.textSize= 30F
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "*"
                expression.text= expressionString

            }

        }

        add.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            var expressionString = expression.text.toString()
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "+"
                expression.text= expressionString

            }
        }

        divide.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            var expressionString = expression.text.toString()
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "/"
                expression.text= expressionString

            }
        }

        backspace.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().isNotEmpty()){
                val lastIndex =expression.text.toString().lastIndex
                tempStr=expression.text.toString().substring(0,lastIndex)
                expression.text = tempStr
            }
        }

        subtract.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            var expressionString = expression.text.toString()
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "-"
                expression.text= expressionString

            }
        }

        zero.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"0"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"0"
                resultText()
            }
        }

        dot.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            var expressionString = expression.text.toString()
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "."
                expression.text= expressionString

            }

        }

        doublezero.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"00"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"00"
                resultText()
            }
        }

        percent.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            var expressionString = expression.text.toString()
            if(isCalculation(expressionString)){
                expression.text=expressionString
                //no change
            }
            else{
                expressionString += "%"
                expression.text= expressionString

            }
        }

        one.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"1"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"1"
                resultText()
            }
        }

        two.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"2"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"2"
                resultText()
            }

        }

        three.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"3"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"3"
                resultText()
            }

        }

        four.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"4"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"4"
                resultText()
            }

        }

        five.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"5"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"5"
                resultText()
            }

        }

        six.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"6"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"6"
                resultText()
            }

        }

        seven.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"7"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"7"
                resultText()
            }

        }

        eight.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"8"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"8"
                resultText()
            }

        }

        nine.setOnClickListener(){
            expression.textSize = 60F
            result.textSize= 30F
            if(expression.text.toString().startsWith("0")){
                expression.text=expression.text.toString().replace("0","")+"9"
                //no change
                resultText()
            }
            else{
                expression.text = expression.text.toString()+"9"
                resultText()
            }

        }
    }
    private fun  isCalculation(exp:String): Boolean {
        var isCalc: Boolean= false;
        if(exp.endsWith("%")|| exp.endsWith("*")|| exp.endsWith("/")
            || exp.endsWith("+")||exp.endsWith("-")||exp.endsWith(".")){
            isCalc =true
        }
        return isCalc
    }
    /*
    private fun concetaneWcalc(exp: String, calc: String){
        exp += calc;

    }
    */

    private fun resultText() {
        val exp= expression.text.toString()
        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try{
            val res = engine.eval(exp)
            result.text= res.toString()
        }
        catch (e:Exception){
            expression.text = expression.text.toString()
            result.text= expression.text.toString()
        }
    }
}