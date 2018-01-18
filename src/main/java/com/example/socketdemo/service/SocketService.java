package com.example.socketdemo.service;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketService {
        public static final String IP_ADDR = "192.168.0.178";//服务器地址
        public static final int PORT = 4001;//服务器端口号
        private DataInputStream input;
        private DataOutputStream output;
        private Socket socket;
        private String retStr;
        public void init() {
            System.out.println("客户端启动...");
            System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
            int try_times=16;
            for(int i=0;i<=16;i++) {
                socket = null;
                try {
                    //创建一个流套接字并将其连接到指定主机上的指定端口号
                    socket = new Socket("192.168.0.178", 4001);

                    //读取服务器端数据
                     input = new DataInputStream(socket.getInputStream());
                    //向服务器端发送数据
                     output = new DataOutputStream(socket.getOutputStream());
//                    System.out.print("请输入: \t");
//                    String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
//                    out.writeUTF(str);
//
//                    String ret = input.readUTF();
//                    System.out.println("服务器端返回过来的是: " + ret);
//                    // 如接收到 "OK" 则断开连接
//                    if ("OK".equals(ret)) {
//                        System.out.println("客户端将关闭连接");
//                        Thread.sleep(500);
//                        break;
//                    }

//                    output.close();
//                    input.close();
                } catch (Exception e) {
                    System.out.println("客户端异常:" + e.getMessage());
                    e.printStackTrace();
                }
//                } finally {
//                    if (socket != null) {
//                        try {
//                            socket.close();
//                        } catch (IOException e) {
//                            socket = null;
//                            System.out.println("客户端 finally 异常:" + e.getMessage());
//                        }
//                    }
//                }
                if(i==15){
                    System.out.println("无法连接服务器，请检查联通性");
                }
            }
        }

    public void start(){
            retStr=null;
            String str="\\xA0 \\x04 \\x01 \\x74 \\x00 \\xE7";
            //响应 A0 04 01 74 10 D7 成功
//            byte[] bytes={160,4,1,116,0,231};//天线1 后两位 00 e7 tianxian2 01 e6 tianxian3 02 e5 tianxian4 03 e4
            byte bytes[]={(byte)0xA0,0x04,0x01,0x74,0x00,(byte)0xe7};
            try{
//                output.write(bytes,0,bytes.length);
                output.writeUTF(str);
                retStr=input.readUTF();

                System.out.println("发送成功,input:"+retStr);
            }
            catch (Exception e){
                System.out.println("发送不成功");
                e.printStackTrace();
            }
    }
    public String read(){
            String str="\\xA0\\x13\\x01\\x89\\x01\\xD1";
//            byte[] bytes={160,19,1,137,1,209};//还不行就用0xa0 0x13的方式试一次
            byte[] bytes={(byte)0xA0,0x13,0x01,(byte)0x89,0x01,(byte)0xD1};
            retStr=null;
        try{
//            output.write(bytes,0,bytes.length);
            output.writeUTF(str);
            retStr=input.readUTF();
            System.out.println("发送成功,input:"+retStr);
        }
        catch (Exception e){
            System.out.println("发送不成功");
            e.printStackTrace();
        }finally {
            return retStr;
        }
    }
    public void stop(){

           try{
               input.close();
               output.close();
               if (socket != null) {
                   try {
                       socket.close();
                   } catch (IOException e) {
                       socket = null;
                       System.out.println("客户端 finally 异常:" + e.getMessage());
                   }

            }
           }
            catch (Exception e){
               System.out.println("got problem");
               e.printStackTrace();
            }
    }

    }


