package week5.lab;

import java.util.*;

public class thirdTask {
    public abstract class Box
    {
        public abstract void add(Thing thing);

        public void add(Collection<Thing> things)
        {
            for(Thing thing : things)
            {
                add(thing);
            }
        }
        public abstract boolean isInTheBox(Thing thing);
    }
    public class Thing extends Box {
        private int weight;
        private String name;

        Map<String, Integer> boxMap = new HashMap<String, Integer>();

        public Thing(int weight, String name) {
            if (weight < 0) {
                throw new IllegalArgumentException("Weight cannot be less than 0");
            } else {
                this.weight = weight;
                this.name = name;
            }
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public void add(Thing thing) {
            boxMap.put(thing.name, thing.weight);
        }

        @Override
        public boolean isInTheBox(Thing thing) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean equals(Object obj) {
            boolean isEqual = false;
            if (obj != null && obj instanceof Thing) {//If the condition is true, it casts the object to a
                // Thing and compares the name field of the current object (this) with the name field of the other object ((Thing) object).
                isEqual = (this.name == ((Thing) obj).name); //Using == for string comparison checks if the references are the same,
                // not if the actual content of the strings is the same.
            }
            return isEqual;
        }
        //public class StringComparisonExample {
        //    public static void main(String[] args) {
        //        String str1 = "hello";
        //        String str2 = "hello";
        //        String str3 = new String("hello");
        //
        //        // Using == to compare string references
        //        System.out.println("Using == for string references:");
        //        System.out.println(str1 == str2);  // true (both point to the same string pool object)
        //        System.out.println(str1 == str3);  // false (different objects in memory)
        //
        //        // Using .equals() to compare string content
        //        System.out.println("\nUsing .equals() for string content:");
        //        System.out.println(str1.equals(str2));  // true (same content)
        //        System.out.println(str1.equals(str3));  // true (same content)
        //    }
    }
        public class MaxWeightBox extends Box
        {
            private int maxWeight;
            private int currentWeight;

            private List<Thing> box;

            public MaxWeightBox(int maxWeight)
            {
                this.currentWeight=0;
                this.maxWeight=maxWeight;
                this.box=new ArrayList<Thing>();
            }

            @Override
            public void add(Thing thing) {
                if(thing.getWeight()<=this.maxWeight-this.currentWeight)
                {
                    box.add(thing);
                    this.currentWeight+=thing.getWeight();
                }
            }

            @Override
            public boolean isInTheBox(Thing thing) {
                boolean found=false;
                for(Thing t : box)
                {
                    if(t.equals(thing))
                    {
                        found=true;
                        break;
                    }
                }
                return found;
            }
        }
        public class OneThingBox extends Box{
        private int numOfThings;
        private List<Thing> box;
        public OneThingBox()
        {
            this.numOfThings=0;
            this.box=new ArrayList<Thing>();
        }

            @Override
            public void add(Thing thing) {

                      if (numOfThings < 1) {
                          box.add(thing);
                          numOfThings = 1;
                      }
            }

            @Override
            public boolean isInTheBox(Thing thing) {
                boolean found=false;
                for(Thing t : box)
                {
                    if(t.equals(thing))
                    {
                        found=true;
                    }
                }return found;
            }
        }
        public class  BlackHoleBox extends Box
        {
            private int numOfThings;
            private List<Thing> box;
            public BlackHoleBox()
            {
                this.numOfThings=0;
                this.box=new ArrayList<Thing>();
            }

            @Override
            public void add(Thing thing) {
                if(numOfThings==0)
                {
                    box.add(thing);
                }
            }

            @Override
            public boolean isInTheBox(Thing thing) {
                //return false;
                boolean found=true;
                for(Thing t : box)
                {
                    if(t.equals(thing))
                    {
                        found=false;  // If a matching thing is found, update 'found' to false
                    }
                }
                return found;
            }
        }
    }


