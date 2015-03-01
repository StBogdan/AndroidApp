package com.example.bogdan.reteta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {
    ListView listView ,listView2,listView3;
    String[] allValues = new String[] { "Vegetable Soup",
            "Italian Meatballs",
            "Basic Chocolate Mousse",
            "Vegetarian Chili",
            "Sear-Roasted Lamb Loin Chops"
    };

    HashMap<String,Integer> allNumbers;
    String[][] allDetails = new String[][] {
            {"1 hour","easy","7"},
            {"30 min plus 40 mins cooking time","easy","12"},
            {"25 mins plus 2 hours chilling time","medium","5"},
            {"45 mins", "medium" , "7"},
            {"20 mins", "medium-hard","3"}
    };

    String[][] allSteps = new String[][]{
            {"Heat the olive oil in a large saucepan or Dutch oven over medium-high heat until shimmering. Add the onion, season with salt and pepper, and cook, stirring occasionally, until translucent, about 5 minutes.","Add the carrots and garlic, season with salt and pepper, and cook, stirring occasionally, until the garlic is fragrant, about 2 minutes.","Add the celery and, if using, any hearty vegetables (such as cabbage and fennel) and the bay leaf and thyme. Season again with salt and pepper and cook an additional 5 minutes. If using, add the wine or vermouth (for some acidity) and cook, stirring occasionally, until the alcohol has reduced by about half, about 2 minutes","Add the broth, potatoes, and any quicker-cooking vegetables (such as asparagus and peas). Let the soup come to a boil, then reduce the heat to low and gently simmer, uncovered, until the potatoes can be easily pierced with a fork, about 15 to 25 minutes. Taste and season with additional salt and pepper as needed. If you choose, serve with a dollop of pesto."},
            {"Cut the bread into roughly 3/4-inch cubes (you should have about 3 cups) and place in a small bowl. Add just enough milk to cover the bread, pressing down with your hands so the cubes absorb the milk. Let stand 5 minutes", "Meanwhile, place the tomato sauce and water in a large saucepan with a tightfitting lid. Bring to a boil over medium-high heat, then lower to a simmer. Taste and season as needed with salt and pepper","Place the flour in a shallow bowl. Fill a small bowl with cold water; set both aside.", "Place the beef and pork in a large bowl. Mix together with your hands until evenly combined. Using your fingers, break the soaked bread into small pieces. Squeeze the excess milk from the bread back into the small bowl and add the bread to the meat mixture; discard the milk", "Add the eggs, garlic, Parmesan, and parsley to the meat mixture. Season with a few large pinches of salt and a few small pinches of pepper. Using your hands, quickly mix until evenly combined. To taste for seasoning, form a small patty of the meat mixture and cook it in a small frying pan over medium heat until no longer pink inside. Taste the patty and add more salt and pepper to the meat mixture as needed. Repeat the frying test as needed.","Form the mixture into 1-1/2-inch balls. If your hands stick to the meat, wet them in the bowl of water. Roll the meatballs in the reserved flour until they are lightly coated, then drop each meatball into the simmering sauce. Cover the saucepan and simmer without disturbing to let the meatballs set, about 5 minutes. Gently stir and continue to simmer, covered, until the meatballs are no longer pink inside, about 35 minutes more. Remove the lid and simmer until the sauce has thickened, about 5 minutes (for a thicker sauce, continue to simmer to the desired consistency)" },
            {"Fill a medium saucepan with 2 inches of water and bring to a simmer over medium heat.","Place chocolate and 1/4 cup of the heavy cream in a large heatproof bowl. (Place remaining cream back in the refrigerator until ready to use.) Nest the bowl over the saucepan, making sure the bottom of the bowl does not touch the water. Melt chocolate, stirring occasionally with a rubber spatula, until smooth and combined with the cream. Remove the bowl from the saucepan and set aside to cool slightly","Place egg whites in a second large bowl and whisk vigorously until stiff peaks form, about 3 minutes (make sure the bowl and whisk have no trace of oil or fat, or the whites will not whip properly); set aside. (Alternatively, you can use an electric mixer","Clean and dry the whisk (or your beaters if you’re using an electric mixer). Place the remaining 3/4 cup heavy cream in a third large bowl and whisk until stiff peaks form. (Alternatively, you can use an electric mixer.)","'Using a rubber spatula, fold half of the whipped cream into the melted chocolate, then gently stir in the rest (try not to deflate the whipped cream). Gently fold the egg whites into the chocolate-cream mixture just until there are no longer large blobs of whipped cream or egg white (do not overmix).","Spoon the mousse or pipe it from a pastry bag into serving cups and refrigerate for at least 2 hours. Serve with additional sweetened or flavored whipped cream if desired."},
            {"Heat the oil in a large heavy-bottomed pot with a tightfitting lid or a Dutch oven over medium heat until shimmering. Add the onions, carrots, and garlic and season with salt and pepper. Cook, stirring occasionally, until the onions have softened, about 5 minutes.","Add the bell pepper and zucchini to the pot and season with salt and pepper. Add the cumin and chili powder and stir to incorporate. Cook, stirring occasionally, until the carrots are knife tender, about 8 to 10 minutes.","'Add the beans, water, and tomatoes with their juices and stir to combine. Increase the heat to high and bring to a boil. Reduce the heat to low and gently simmer until the vegetables are soft and the flavors have melded, about 15 minutes. Taste and season with additional salt and pepper if necessary. Serve and garnish as desired."},
            {"'Add the beans, water, and tomatoes with their juices and stir to combine. Increase the heat to high and bring to a boil. Reduce the heat to low and gently simmer until the vegetables are soft and the flavors have melded, about 15 minutes. Taste and season with additional salt and pepper if necessary. Serve and garnish as desired.","Pat the lamb chops dry with paper towels, then season generously all over with salt and pepper.","Place a thin film of oil in the bottom of a large ovenproof frying pan and heat over medium-high heat until smoking. Add the lamb chops and cook undisturbed until a golden-brown crust forms on the bottom, about 3 minutes. Flip and cook undisturbed until the second side is golden brown and crusty, about 3 minutes more.","Transfer the pan to the oven and roast until the chops register 130°F on an instant-read thermometer for medium rare, about 8 to 10 minutes. Remove from the oven and transfer the chops to a cutting board or serving platter. Tent with foil and let rest 5 minutes before serving."}
    };
    String[] favValues = new String[] { "Basic Chocolate Mousse",
            "Italian Meatballs"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* allNumbers.put("Vegetable Soup",1);
        allNumbers.put("Italian Meatballs",2);
        allNumbers.put( "Basic Chocolate Mousse",3);
        allNumbers.put("Vegetarian Chili",4);
        allNumbers.put( "Sear-Roasted Lamb Loin Chops",5);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listView2= (ListView) findViewById(R.id.listView2);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allValues);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favValues);
        listView.setAdapter(adapter);
        listView2.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.recipedisplay);
                for (int i=0; i< allValues.length;i++) if( allValues[i].equals(parent.getItemAtPosition(position).toString()))
                {
                    ((TextView) findViewById(R.id.trouble)).setText( allValues[i]);
                    ((TextView) findViewById(R.id.time)).setText(  allDetails[i][0]);
                    ((TextView) findViewById(R.id.diff)).setText(  allDetails[i][1]);
                    ((TextView) findViewById(R.id.portions)).setText(  allDetails[i][2]);
                    listView3= (ListView) findViewById(R.id.listView3);
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, allSteps[i]);
                    listView3.setAdapter(adapter3);
                }

        }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.recipedisplay);
                ((TextView) findViewById(R.id.trouble)).setText( parent.getItemAtPosition(position).toString());
                for (int i=0; i< allValues.length;i++) if( allValues[i].equals(parent.getItemAtPosition(position).toString()))
                {
                    ((TextView) findViewById(R.id.trouble)).setText( allValues[i]);
                    ((TextView) findViewById(R.id.time)).setText(  allDetails[i][0]);
                    ((TextView) findViewById(R.id.diff)).setText(  allDetails[i][1]);
                    ((TextView) findViewById(R.id.portions)).setText(  allDetails[i][2]);
                    listView3= (ListView) findViewById(R.id.listView3);
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, allSteps[i]);
                    listView3.setAdapter(adapter3);
                }
            }
        });
    }
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }

}

