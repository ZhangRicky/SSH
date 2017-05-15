package org.python;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 * Java调用Python语言
 * 1，调用文件的方式进行操作
 * 2，通过执行python命令方式也能进行操作 
 * @author Mark
 *
 */
public class ReadLine {

	public static void main(String[] args) throws IOException {
		

		
		
		PythonInterpreter interpreter = new PythonInterpreter(); 
		
		//String file = "E:\workspace\tdx\com\Test.py";
		
		 InputStream filepy = new FileInputStream("E:\\workspace\\SSH\\src\\main\\java\\com\\jpthon\\Test.py"); 
		 
		 interpreter.execfile(filepy); 
		 
		PyFunction function = (PyFunction)interpreter.get("exactStock",PyFunction.class); 
		PyObject o = function.__call__(new PyString("E:\\workspace\\SSH\\src\\main\\java\\com\\jpthon\\sh000001.day"),new PyString("000001"));
		System.out.println(o.toString());
	}
 
}
