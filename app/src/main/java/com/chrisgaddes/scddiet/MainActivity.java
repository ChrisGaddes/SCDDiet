package com.chrisgaddes.scddiet;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.chrisgaddes.scddiet.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String[] MOVIES = new String[]{
            "Acorn Squash",	"Agar-agar",	"Agave syrup",	"Algae",	"Allspice",	"Almond butter",	"Almond milk",	"Almond oil",	"Almonds",	"Aloe Vera",	"Amaranth flour",	"Anchovies",	"Apple Cider",	"Apple Juice",	"Apples",	"Apricots",	"Arrowroot",	"Artichokes (French)",	"Artichokes (Jerusalem)",	"Ascorbic acid",	"Asiago cheese",	"Asparagus",	"Aspartame",	"Aspartic acid",	"Astragalus",	"Avocado oil",	"Avocadoes",	"Bacon",	"Baker's yeast",	"Baking powder",	"Baking soda",	"Balsamic vinegar",	"Bananas",	"Bark tea",	"Barley",	"Basil",	"Bay Leaf",	"Bean flour",	"Bean sprouts",	"Bee Pollen",	"Beef",	"Beer",	"Beets",	"Berries",	"Bhindi",	"Bitter Gourd",	"Black beans",	"Black eye beans",	"Black radish",	"Blue cheese",	"Bok Choy",	"Bologna",	"Bouillon cubes",	"Bourbon",	"Brandy",	"Brazil nuts",	"Brick cheese",	"Brie cheese",	"Broccoli",	"Brussell sprouts",	"Buckwheat",	"Bulgur",	"Burdock root",	"Butter",	"Butter beans",	"Buttermilk",	"Butternut squash",	"Cabbage",	"Camembert cheese",	"Canellini beans",	"Canned fish",	"Canned fruits",	"Canned vegetables",	"Canola oil",	"Cantaloupe",	"Capers",	"Carob",	"Carrageenan",	"Carrots",	"Cashews",	"Cauliflower",	"Celeriac /celery root",	"Celery",	"Cellulose (in supplements)",	"Cellulose Gum",	"Cereals",	"Chard",	"Cheddar cheese",	"Cheese",	"Cherimoya",	"Cherries",	"Chestnut flour",	"Chestnuts",	"Chevre",	"Chewing gum",	"Chick peas",	"Chickory root",	"Chlorella",	"Chocolate",	"Cilantro",	"Cinnamon",	"Citric Acid",	"Club soda",	"Cocoa powder",	"Coconut",	"Coconut milk",	"Coconut oil",	"Coffee",	"Coffee (instant)",	"Colby cheese",	"Collard greens",	"Cordials",	"Corn",	"Corn oil",	"Corn syrup",	"Cornstarch",	"Cottage cheese",	"Courgette",	"Cranberry juice",	"Cream",	"Cream cheese",	"Cream of Tartar",	"Croscomellose sodium",	"Cucumbers",	"Custard apple",	"Cyclamate",	"Date sugar",	"Dates",	"Decaffeinated Products",	"Dextrose (contained in commercial products)",	"Dried milk solids",	"Drumsticks",	"Dry Curd Cottage Cheese (DCCC)",	"Durum Flour",	"Echinacea",	"Edam cheese",	"Eggplant",	"Eggs",	"EMPower",	"Ethanol",	"Evaporated cane juice",	"Ezekiel Bread",	"Faba beans",	"Fenugreek",	"Feta Cheese",	"Figs",	"Filberts (hazelnuts)",	"Fish",	"Flax seed",	"Flax seed oil",	"Flour",	"FOS",	"Fowl",	"Frozen Orange Juice (concentrated)",	"Fructose (granulated)",	"Fruits (canned)",	"Garbanzo beans",	"Garfava flour",	"Garlic",	"Gelatin (unflavored)",	"Ghee",	"Gin",	"Ginger",	"Gjetost cheese",	"Glucose candy",	"Glycerin",	"Glycerol",	"Goatein",	"Gorgonzola cheese",	"Gouda cheese",	"Granulated glucose",	"Grape juice",	"Grapefruit",	"Grapefruit juice",	"Grapes",	"Grapeseed oil",	"Green tea",	"Gruyere cheese",	"Guar Gum",	"Gums",	"Ham",	"Haricot beans",	"Havarti cheese",	"Hazelnuts (filberts)",	"Hemp seed, Hemp protein powder",	"HN-Zyme",	"Homemade yogurt",	"Honey",	"Horseradish sauce",	"Hot dogs",	"Hydrolyzed Protein",	"Ice cream",	"Inositol",	"Inulin",	"Iron supplements",	"Isoglucose",	"Jaggery (gur)",	"Jalapenos",	"Jicama",	"Juice from concentrate",	"Kale",	"Kefir",	"Ketchup",	"Kidney beans",	"Kimchi",	"Kiwi fruit",	"Kohlrabi",	"Kudzu (or kuzu)",	"Kumquats",	"KyoGreen powder",	"L-Theanine",	"Lactaid Milk",	"Lactose Hydrolyzed Milk",	"Lamb",	"Lecithin",	"Leek",	"Lemons",	"Lentils",	"Lettuce",	"leucine",	"Licorice",	"Lignin",	"Lima beans",	"Limburger cheese",	"Limes",	"Liqueurs",	"Liquid Clorychlorophyll",	"Macadamia nuts",	"Macadamia oil",	"Magnesium citrate",	"Magnesium Stearate",	"Maltitol",	"Maltodextrin",	"Manchego Cheese",	"Mangoes",	"Mannitol",	"Maple syrup",	"Margarine",	"Marshmallow",	"Mastic gum",	"Mead",	"Meats",	"Meats (canned)",	"Meats (processed)",	"Melatonin",	"Melon",	"Milk",	"Millet",	"Miso",	"Molasses",	"Molo-cure",	"Monterey Jack cheese",	"Mozzarella cheese",	"MSG",	"Mucilaginous Herbs",	"Mucilaginous Polysaccharides",	"Muenster cheese",	"Mungbeans",	"Mushrooms",	"Mustard (plain)",	"Natural cheeses",	"Natural Flavors",	"Navy beans",	"Nectarines",	"Nettles",	"Neufchatel cheese",	"Noni Juice",	"Nutmeg",	"Oats",	"Okra",	"Olive oil",	"Olives",	"Onions",	"Orange juice",	"Oranges",	"Oregano",	"Papayas",	"Pappadum",	"Paprika",	"Parmesan cheese",	"Parsley",	"Parsnips",	"Passion Fruit",	"Pasta",	"Pau 'Arco",	"Pea flour",	"Peaches",	"Peanut butter",	"Peanut Oil",	"Peanuts",	"Pears",	"Peas",	"Pecans",	"Pectin",	"Peppermint tea",	"Peppers",	"Peptizyde",	"Persimmons",	"Phosphatidylcholine",	"Pickles (dill)",	"Pine nuts",	"Pineapple",	"Pineapple juice",	"Pinto beans",	"Pistachio nuts",	"Plantains",	"Plums",	"Polysorbate 80",	"Pomegranate concentrate",	"Pork",	"Pork Rinds",	"Port du Salut cheese",	"Port wine",	"Postum",	"Potassium Sorbate",	"Potatoes",	"Poultry",	"Primal Defense",	"Primost cheese",	"Processed cheeses",	"Protein powder",	"Provolone cheese",	"Prunes",	"Psyllium husks",	"Pumpkin",	"Pumpkin (canned)",	"Quinoa",	"Quorn",	"Raisins",	"Rhubarb",	"Rice",	"Rice Bran",	"Rice Flour",	"Ricotta cheese",	"Romano cheese",	"Roquefort cheese",	"Rosemary",	"Rutabaga",	"Rye",	"Saccharine",	"Safflower oil",	"Sage",	"Sago starch",	"Sake",	"Salt",	"Sashimi",	"saukerkraut",	"Seaweed",	"Seed Butters",	"Seed Flour",	"Seeds",	"Sesame oil",	"Sesame seeds",	"Sharifa",	"Shellfish",	"Sherry",	"Silica",	"Silicon Dioxide",	"Slippery elm",	"Smoked meats",	"Sodium Benzoate",	"Sodium starch glycinate",	"Sorbitol",	"Sour cream",	"Soy",	"Soy Lecithin",	"Soy Sauce",	"Soybean milk",	"Soybean oil",	"Soybeans",	"Spearmint Tea",	"Spelt",	"Spices",	"Spinach",	"Spirulina",	"Splenda",	"Split peas",	"Sprouted Grain Bread",	"Squash",	"Stevia",	"Stilton cheese",	"String beans",	"Sucralose",	"Sulphates",	"Sunflower oil",	"Swede",	"Sweet Potatoes",	"Swiss cheese",	"Tabasco sauce",	"Tagatose",	"Tamari",	"Tamarind",	"Tangerines",	"Tapioca",	"Tapioca Flour",	"Taro",	"Tarragon",	"Tea",	"Thyme",	"Tofu",	"Tofutti cheese",	"tomato",	"Tomato juice (canned)",	"Tomato paste (canned)",	"Tomato pur&eacute;e (canned)",	"Tomato sauce (canned)",	"Triticale",	"Turbinado",	"Turnips",	"V8 Juice",	"Vanillin",	"Vegetable stearate",	"Vegetables (canned)",	"Vinegar",	"Vodka",	"Walnut oil",	"Walnuts",	"Wasabi",	"Water chestnuts",	"Watercress",	"Watermelon",	"Wheat",	"Wheat germ",	"whisky",	"Wine",	"Xanthum Gum",	"Xylitol",	"Yams",	"Yoghurt (commercial)",	"Yoghurt (homemade)",	"Yucca Root",	"Zucchini",

    };

    private static final Comparator<ExampleModel> ALPHABETICAL_COMPARATOR = new Comparator<ExampleModel>() {
        @Override
        public int compare(ExampleModel a, ExampleModel b) {
            return a.getText().compareTo(b.getText());
        }
    };

    private ExampleAdapter mAdapter;
    private List<ExampleModel> mModels;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new ExampleAdapter(this, ALPHABETICAL_COMPARATOR, new ExampleAdapter.Listener() {
            @Override
            public void onExampleModelClicked(ExampleModel model) {
                final String message = getString(R.string.model_clicked_pattern, model.getText());
                Snackbar.make(mBinding.getRoot(), message, Snackbar.LENGTH_SHORT).show();
            }
        });

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mAdapter);

        mModels = new ArrayList<>();
        for (int i = 0, count = MOVIES.length; i < count; i++) {
            mModels.add(new ExampleModel(i, MOVIES[i]));
        }
        mAdapter.edit()
                .replaceAll(mModels)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<ExampleModel> filteredModelList = filter(mModels, query);
        mAdapter.edit()
                .replaceAll(filteredModelList)
                .commit();
        mBinding.recyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private static List<ExampleModel> filter(List<ExampleModel> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<ExampleModel> filteredModelList = new ArrayList<>();
        for (ExampleModel model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}