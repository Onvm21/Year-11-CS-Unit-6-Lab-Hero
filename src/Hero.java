public class Hero {
    private String name;
    private int hitPoints;

    private int[] wins;

    public Hero(String name){
        this.hitPoints = 100;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return("Hero{" + "name='" + name + '\'' + ", hitPoints=" + hitPoints + '}');
    }

    public void attack(Hero opponent){
        double random = Math.random();
        if (random<0.5){
            opponent.hitPoints -= 10;
        }
        else{
            hitPoints -= 10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.getHitPoints() > 0 && this.hitPoints>0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        this.senzuBean();
        opponent.senzuBean();
        this.fightUntilTheDeathHelper(opponent);
        System.out.println(this.name + ": " + this.hitPoints + " "+opponent.name + ": " + opponent.hitPoints);
        return(this.name + ": " + this.hitPoints + " "+opponent.name + ": " + opponent.hitPoints);
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int [] wins= {0,0};
        for(int i = 0; i<n; i++){
            opponent.senzuBean();
            this.senzuBean();
            fightUntilTheDeath(opponent);
            if(opponent.hitPoints == 0){
                wins[0] = wins[0] + 1; // first thing is hero
            }else if(this.hitPoints == 0){
                wins[1] = wins[1]+ 1;
            }
        }
        return(wins);
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        this.wins = nFightsToTheDeathHelper(opponent, n);
        if(wins[0]>wins[1]){
            return(this.name + ": " + wins[0] +" wins" + "\n" +opponent.name + ": " + wins[1] +" wins" + "\n"+ this.name + " wins!");
        }else if(wins[1]>wins[0]){
            return(this.name + ": " + wins[0] +" wins" + "\n" +opponent.name + ": " + wins[1] +" wins" + "\n"+opponent.name +" wins!");
        }else{
            return(this.name + ": " + wins[0] +" wins" + "\n" +opponent.name + ": " + wins[1] +" wins" + "\n"+"OMG! It was actually a draw!");
        }
    }




    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        opponent.senzuBean();
        this.senzuBean();
        while (opponent.hitPoints > 0 && this.hitPoints>0){
            attack(opponent);
            Thread.sleep(1000);
            System.out.println(this.name+": " +this.hitPoints + "     " + opponent.name +": "+opponent.hitPoints+"\n");
        }
        if (this.hitPoints > opponent.hitPoints){
            System.out.println(this.name + " wins!");
        }else{
            System.out.println(opponent.name + " wins!");
        }
    }
}
