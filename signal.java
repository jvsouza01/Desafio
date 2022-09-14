package br.jv;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class signal {

    static Semaphore s = new Semaphore(2);


  public static class SampleThread extends Thread {
      String name = "";

      SampleThread(String name) {
          this.name = name;
      }

      public void run() {

          try {
              //  System.out.println("Available number of permits for " + name + " is: " + s.availablePermits());
              System.out.println(name + " está: vermelho ");
              sleep(5000);

              s.acquire();
              System.out.println(name + " está: verde ");
              sleep(2000);
              System.out.println("O automóvel avançou. ");
              sleep(15000);
              System.out.println("O automóvel alcançou 70km/h");
              sleep(3000);

              try {
                  for (int i = 0; i < 2; i++) {

                          System.out.println(" Próximo " + name  +  "  está: verde "  );
                          Thread.sleep(10000);
                  }
              }
                finally {
                    System.out.println(name + " releasing permit");
                    s.release();
                    System.out.println("Available number of permits for " + name + " is: " + s.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
          }
          public static void main (String[]args) throws InterruptedException {


              SampleThread st1 = new SampleThread(" Semáforo ");

              st1.start();


          }

      }
