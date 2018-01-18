package com.example.socketdemo.service.impl;

import com.example.socketdemo.service.PyService;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service
public class PyServiceImpl implements PyService {
    final static String file_path="/home/wcsn/yang-workspace/javaweb/read.py";
    @Override
    public boolean start(int index) {
            String[] argv={"1"};
       try{
            PythonInterpreter.initialize(null,null,argv);
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile(file_path);
            PyFunction pyFunction=interpreter.get("start",PyFunction.class);
            PyObject pyObject=pyFunction.__call__();
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
       return  true;
    }

    @Override
    public String read() {
        try{

            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile(file_path);
            PyFunction pyFunction=interpreter.get("read",PyFunction.class);
            PyObject pyObject=pyFunction.__call__();
            return pyObject.toString();
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public boolean stop() {
        try{

            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile(file_path);
            PyFunction pyFunction=interpreter.get("stop",PyFunction.class);
            PyObject pyObject=pyFunction.__call__();
        }catch (Exception e){
            return false;
        }
        return  true;
    }

    @Override
    public boolean write(String code) {
        try{

            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile(file_path);
            PyFunction pyFunction=interpreter.get("write",PyFunction.class);
            PyObject pyObject=pyFunction.__call__();
        }catch (Exception e){
            return false;
        }
        return  true;
    }
}
