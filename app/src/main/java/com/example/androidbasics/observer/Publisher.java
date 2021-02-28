package com.example.androidbasics.observer;

public interface Publisher {

   void registerObservers( Observer observer);
   void unregisterObservers(Observer observer);
   void publishPoints();
}
