package com.example.journeyonadice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetSample {
    private Socket s = null;
    private PrintWriter pw = null;
    private BufferedReader br = null;

    public void connect(String host, int port) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    // ストリームソケットを作成し、指定されたホスト上の指定されたポート番号に接続
                    s = new Socket(host, port);

                    // ソケットの出力ストリームを取得し、送信バッファ(PrintWriter)と関連付け
                    pw = new PrintWriter(s.getOutputStream());

                    // データを受信するときは BufferedReaderのインスタンスに対して行う
                    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void send(String data) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    // 送信バッファへ書き込み
                    pw.println(data);

                    // ストリームをフラッシュ（送信される）
                    pw.flush();
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void close() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (s != null) {
                        // ソケットを閉じる（PrintWriterを閉じると関連付けられたソケットも閉じられる）
                        s.close();
                        s = null;
                    }
                }
                catch(Exception e) {

                }
            }
        }).start();
    }
}
