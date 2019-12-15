package Model;

import java.util.Random;

public class FakeData {
	private static final Random random = new Random();

	public FakeData() {
	}

	/**
	 * @return a random first name out of 200
	 */
	public String firstName() {
		String[] firstName = { "Randolph", "Benedikta", "Helen", "Derril", "Lanie", "Morgun", "Claudina", "Terrill",
				"Liam", "Pavel", "Gert", "Rasla", "Georas", "Maximilianus", "Lauren", "Randy", "Audrey", "Aleece",
				"Portie", "Cori", "Chandal", "Teddy", "Delphinia", "Tamqrah", "Kearney", "Dicky", "Jordanna", "Ethe",
				"Jami", "Livia", "Maxwell", "Kris", "Cele", "Chrisy", "Creighton", "Lynnet", "Noby", "Patrizius",
				"Meghan", "Gorden", "Filia", "Fey", "Nanice", "Cayla", "Cally", "Gennifer", "Hart", "Jacquelyn",
				"Giles", "Lula", "Moshe", "Agace", "Augusto", "Zeb", "Benedetto", "Angil", "Jerrine", "Field", "Paulie",
				"Cherrita", "Mabelle", "Sly", "Friedrick", "Barnaby", "Novelia", "Royce", "Felecia", "Shaun", "Arch",
				"Onida", "Brandice", "Opalina", "Mord", "Ketti", "Guthrey", "Vania", "Lucine", "Arabel", "Si",
				"Chrystel", "Norri", "Guillema", "Lonna", "Abe", "Radcliffe", "Lavina", "Modesty", "Thomasa", "Taite",
				"Roseanna", "Tannie", "Torrie", "Isidora", "Harley", "Giana", "Marion", "Opaline", "Jock", "Drucie",
				"Oralia", "Oralle", "Jaquelyn", "Corrinne", "Crissy", "Herrick", "Evelina", "Teodoor", "Aubry",
				"Aubert", "Evangelin", "Gualterio", "Eldin", "Ezmeralda", "Mandie", "Matthias", "Ted", "Antonia",
				"Farley", "Kerstin", "Gerianne", "Zonnya", "Burnard", "Bibbie", "Berny", "Carce", "Corinna", "Carlin",
				"Nanni", "Cris", "Gael", "Reynolds", "Nilson", "Sonnie", "Giles", "Ansel", "Arther", "Farand", "Travus",
				"Latisha", "Yvon", "Khalil", "Malvina", "Jae", "Debbi", "Kristo", "Rodolphe", "Melania", "Cathee",
				"Delila", "Corena", "Bron", "Stevy", "Belia", "Claus", "Mord", "Helaine", "Florance", "Aluino", "Mort",
				"Had", "Darby", "Lydon", "Julietta", "Kristin", "Franchot", "Felicity", "Thomas", "Bibbie", "Vanda",
				"Spencer", "Corey", "Pren", "Ysabel", "Corella", "Mace", "Kermit", "Son", "Fredric", "Alaster",
				"Winonah", "Ignacio", "Gavrielle", "Evey", "Curtice", "Marline", "Craggy", "Donnie", "Perceval",
				"Emmye", "Salomi", "Khalil", "Lenka", "Viviana", "Karilynn", "Randi", "Haze", "Christian", "Arielle",
				"Teador", "Whittaker" };
		return firstName[random.nextInt(199) + 0];
	}

	/**
	 * @return a random last name out of 200
	 */
	public String lastName() {
		String[] lastName = { "Pakenham", "Storr", "Sink", "Huc", "Potes", "Graith", "Pentycost", "Elliott", "MacVay",
				"Bavage", "Thurborn", "Stonhouse", "Treharne", "Nemchinov", "Beretta", "Leverson", "Goddard",
				"Houdmont", "Lurriman", "Hanalan", "Duffy", "Osborn", "Gowling", "Lowde", "Croughan", "Kynoch",
				"Tommasetti", "Pinchback", "Verity", "McMillan", "Aldersey", "Scarlon", "Pordall", "Goymer", "Conville",
				"Darbyshire", "Rosterne", "Cason", "Pegram", "Shilburne", "Tyndall", "Giannazzi", "Morrott", "Cambell",
				"Maharry", "Seiller", "Reuss", "L'oiseau", "Lipson", "Blundan", "Jerger", "Bengtsen", "MacCallion",
				"Inde", "Andriessen", "Oager", "Billes", "Valois", "Beatens", "Jaycox", "Dawber", "Sempill", "Daynter",
				"Dommett", "Renyard", "Caffin", "Mattessen", "Quinton", "Piechnik", "Emilien", "McDermot", "Osmund",
				"Kanter", "de Guise", "Rosenstock", "Storm", "Gytesham", "Snoxill", "Capon", "Willshere", "Stockwell",
				"Manford", "Cristofori", "Denver", "Pretti", "Griffey", "Kattenhorn", "Binnie", "Vassano", "Giacovazzo",
				"Ropkins", "Wort", "Weldon", "Plewman", "Sinton", "Krzyzowski", "Gilbeart", "Osbaldeston", "Instone",
				"Gillio", "Dohrmann", "Van", "Songer", "Duiguid", "Fidler", "Underwood", "Dechelette", "Gerler",
				"Jukubczak", "Janes", "Cometson", "Ridd", "Morrell", "Green", "Mabb", "Skoggins", "O'Bradden",
				"Shetliff", "Ferraro", "Kenworthey", "Jandourek", "Dowsett", "Matuschek", "Gwilym", "McCulloch",
				"Ballendine", "Barsham", "Duncanson", "Budgen", "Guiot", "Eady", "Cornwell", "Cogswell", "Giocannoni",
				"Oppy", "Vandenhoff", "Velden", "Stucke", "Decaze", "Ching", "Jelphs", "Rymell", "Wesgate", "Klaves",
				"Oxteby", "Mordey", "Blakes", "Colqueran", "Blakeman", "Hambelton", "Lezemere", "Jorry", "McCarver",
				"Stivers", "O'Spellissey", "Dailly", "Grenfell", "Brenstuhl", "Mattiassi", "Domone", "Crabbe",
				"Seedman", "Saltmarsh", "Ledingham", "Domenici", "Whitham", "Welsh", "Soper", "Nelligan", "Tart",
				"Aldis", "Medeway", "Rhymes", "Polin", "Varney", "Frarey", "Keeler", "Applegate", "Whiffen", "Kervin",
				"Bramford", "Derisly", "Cochern", "Kensy", "Praton", "Lanyon", "Corbin", "Dudek", "Jurisch", "McCabe",
				"Lesmonde", "Wannes", "Benediktovich", "Monument", "Delacroux", "Quenby", "Lackinton", "Midlane",
				"Bohlin", "Tolworth"

		};
		return lastName[random.nextInt(199) + 0];
	}

	/**
	 * @return a random passport number with 5 numbers and letters
	 */
	public String passport() {
		String[] character = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String passport = "";
		for (int i = 0; i < 6; i++) {
			passport = passport + character[random.nextInt(35) + 0];
		}
		date();
		return passport;

	}

	/**
	 * @return a random date between 01/01/10 and 31/12/19
	 */
	public String date() {
		String[] dates = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String date = dates[random.nextInt(12) + 0];
		if (date.contains("02")) {
			date = dates[random.nextInt(28) + 0] + "/" + date + "/" + dates[random.nextInt(9) + 10];
			;
		} else if (date.contains("01") || date.contains("03") || date.contains("05") || date.contains("07")
				|| date.contains("08") || date.contains("10") || date.contains("12")) {
			date = dates[random.nextInt(31) + 0] + "/" + date + "/" + dates[random.nextInt(9) + 10];
		} else {
			date = dates[random.nextInt(30) + 0] + "/" + date + "/" + dates[random.nextInt(9) + 10];
			;
		}
		return date;
	}

	/**
	 * @return a random priority level
	 */
	public Priority priority() {
		// Low priorities will be the majority of people
		int i = random.nextInt(6) + 0;
		if (i <= 3)
			return Priority.LOW;
		else if (i == 4)
			return Priority.MEDIUM;
		else
			return Priority.HIGH;

	}
}
