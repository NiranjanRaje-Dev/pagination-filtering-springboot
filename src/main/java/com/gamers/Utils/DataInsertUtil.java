package com.gamers.Utils;

import com.gamers.Dto.GameDto;
import com.gamers.Entity.Game;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class DataInsertUtil {

    @Autowired
    RestTemplate restTemplate;

    public void insertDataInDb(){
        System.out.println("Insering Data");

        List<String> gameList = Arrays.asList(
                "Uncharted: Legacy of Atlantis",
                "The Last of Us Part III: New Beginnings",
                "Horizon Zero Dawn: Forbidden Frontier",
                "God of War: Ragnarok",
                "Bloodborne: Moonlit Nightmare",
                "Spider-Man: Web of Shadows",
                "Final Fantasy XV: Echoes of Eternity",
                "Ghost of Tsushima: Legends of the Samurai",
                "Persona 6: Shadow's Reckoning",
                "Gran Turismo 7: High Octane",
                "Demon's Souls: Resurrected",
                "Ratchet & Clank: Rifts Apart",
                "Death Stranding: Timefall",
                "Days Gone: Apocalypse Awaits",
                "Infamous: Second Son",
                "LittleBigPlanet 4: Cosmic Creations",
                "Bloodborne: Curse of the Eldritch",
                "Metal Gear Solid VI: Phantom Menace",
                "The Witcher 4: Vengeance of the Wild",
                "Silent Hill: Echoes of Despair",
                "Sackboy: A Big Adventure",
                "Marvel's Avengers: Rise of Ultron",
                "Resident Evil 8: Village of Shadows",
                "Assassin's Creed: Valhalla - Legacy of Odin",
                "The Elder Scrolls VI: Kingdoms at War",
                "Cyberpunk 2078: Neon Revolution",
                "Watch Dogs: Legion - City of Chaos",
                "Far Cry 6: Island of Insanity",
                "Call of Duty: Black Ops V - Cold War",
                "Destiny 3: Celestial Chronicles",
                "FIFA 24: World Cup Edition",
                "NBA 2K24: Hoops Dynasty",
                "Madden NFL 24: Gridiron Glory",
                "Gran Turismo 8: Racing Royalty",
                "Street Fighter VI: Battle Arena",
                "Tekken 8: Iron Fist Tournament",
                "Soulcalibur VII: Eternal Swords",
                "Dragon Ball Z: Kakarot - Saiyan Saga",
                "Naruto Shippuden: Ultimate Ninja Storm 5",
                "One Piece: Pirate's Legacy",
                "Kingdom Hearts IV: Hearts of Light",
                "Dark Souls V: Shadows Resurfaced",
                "Star Wars Jedi: Fallen Order - Rise of the Sith",
                "Mass Effect 5: Galactic Resurgence",
                "BioShock Infinite: Echoes of Rapture",
                "Borderlands 4: Mayhem Unleashed",
                "Red Dead Redemption III: Outlaws at Dawn",
                "The Division 3: Warlords Reborn",
                "Rainbow Six Siege: Operation Apex",
                "Overwatch 2: Heroes Rising",
                "Fortnite: Battle Royale - Season X",
                "Apex Legends: Legacy of the Legends",
                "Valorant: Agents of Justice",
                "Gears of War 6: Judgment Day",
                "Halo Infinite: Guardians Reborn",
                "Doom Eternal: Hell's Resurgence",
                "Fallout 5: Wasteland Wanderer",
                "The Outer Worlds 2: Galactic Odyssey",
                "Starfield: Journeys Beyond the Stars",
                "Elder Scrolls Online: Tamriel Reborn",
                "Warframe: Empyrean Uprising",
                "Anthem 2.0: Anthem's Redemption",
                "Destiny 2: Forsaken Kingdom",
                "The Legend of Zelda: Breath of the Wild 2",
                "Super Mario Odyssey 2: Cosmic Quest",
                "Metroid Prime 4: Galactic Hunt",
                "Bayonetta 3: Witch's Legacy",
                "Pokémon Scarlet and Violet: Galar's Secret",
                "Animal Crossing: New Horizons - Island Paradise",
                "Splatoon 3: Inkopolis Uprising",
                "Fire Emblem: Three Houses - War of Fates",
                "Xenoblade Chronicles 3: Titans' Awakening",
                "Luigi's Mansion 4: Ghostly Pursuit",
                "Mario Kart 9: Speed Rivals",
                "Super Smash Bros. Ultimate 2: Clash of Icons",
                "Ring Fit Adventure 2: Fitness Odyssey",
                "F-Zero SX: Velocity Surge",
                "Captain Toad: Treasure Tracker - Lost Relics",
                "Donkey Kong Country: Jungle Rampage",
                "Kirby and the Forgotten Land: Dreamer's Quest",
                "WarioWare: Get It Together! - Microgame Madness",
                "Golden Sun: Solstice of Elements",
                "Kid Icarus: Uprising - Ascension",
                "Pikmin 4: Explorers of the Cosmos",
                "Advance Wars: Days of Valor",
                "EarthBound: Echoes of the Past",
                "Star Fox: Legacy of Lylat",
                "Mother 4: Bonds of Destiny",
                "Bayonetta & Vanquish: Dual Assault",
                "Vanquish 2: Firestorm Protocol",
                "Nier: Automata - Reincarnation",
                "Drakengard 4: Divine Conquest",
                "Tales of Arise: Astral Chronicles",
                "Final Fantasy XVI: Echoes of Crystal",
                "Kingdom Hearts V: Keys of Destiny",
                "Dragon Quest XII: World of Shadows",
                "Bravely Default III: Echoes of Eternity",
                "Octopath Traveler 2: Journeys Unbound",
                "Persona 5: Royal Resurrection",
                "Shin Megami Tensei V: Apocalypse Reborn",
                "Yakuza 8: Shadows of Tokyo",
                "Lost Judgment: Justice Prevails",
                "Sakura Wars: Blossoms of War",
                "Astro's Playroom: Cosmic Adventure",
                "Bugsnax: Snack Safari",
                "Demon's Souls Remake: Souls Resurrected",
                "Sackboy: A Big Adventure",
                "Returnal: Infinite Cycle",
                "Ratchet & Clank: Rift Apart",
                "Destruction AllStars: Mayhem Unleashed",
                "Kena: Bridge of Spirits - Spirit Guide",
                "Solar Ash: Celestial Odyssey",
                "Stray: Neon Alley",
                "Ghostwire: Tokyo - Spectral Hunt",
                "Project Athia: Realm Reborn",
                "Final Fantasy VII Remake: Intergrade",
                "Hitman 3: Contracts Unleashed",
                "Resident Evil Village: Shadows of Despair",
                "Pragmata: Cosmic Dystopia",
                "Deathloop: Time War Chronicles",
                "Far Cry 6: Island of Insanity",
                "Riders Republic: Extreme Odyssey",
                "Rainbow Six Extraction: Alien Siege",
                "Back 4 Blood: Zombie Apocalypse",
                "Hogwarts Legacy: Wizard's Chronicle",
                "Starfield: Journeys Beyond the Stars",
                "The Elder Scrolls VI: Kingdoms at War"
        );

        generateRandomGames(gameList.size(),gameList);

        System.out.println("Data Insertion Complete");
    }

    private void generateRandomGames(int count, List<String> gameNameList) {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            /*Game game = new Game(
                    faker.company().name(),
                    faker.date().birthday().toString(),
                    round(random.nextDouble() * (79.99 - 29.99) + 29.99, 2),
                    round(random.nextDouble() * (59.99 - 19.99) + 19.99, 2),
                    random.nextInt(71) + 10,
                    faker.esports().game(),
                    "/img/" + faker.company().name()  + "/" + (random.nextInt(10) + 1),
                    random.nextBoolean() ? "Full Game" : "DLC",
                    random.nextBoolean() ? "PS5" : "PS4",
                    random.nextBoolean() ? "STANDARD" : "DELUXE",
                    round(random.nextDouble() * (5.0 - 3.0) + 3.0, 1)
            );*/

            GameDto game = new GameDto();

            List<String> genreList = new ArrayList<>(Arrays.asList("ACTION","ADVENTURE","HORROR","RACING","RPG","STRATEGY","SPORTS","SHOOTER"));



            game.setGameName(gameNameList.get(i));
            game.setGameReleaseDate(faker.date().birthday());
            game.setPrice(round(random.nextDouble() * (79.99 - 29.99) + 29.99, 2));
            game.setDiscountedPrice(round(random.nextDouble() * (59.99 - 19.99) + 19.99, 2));
            game.setDiscount((double) (random.nextInt(71) + 10));
            game.setGenre(genreList.get(random.nextInt(7)));
            game.setImagePath( "/img/" + gameNameList.get(i)  + "/" + (random.nextInt(10) + 1));
            game.setGameType(random.nextBoolean() ? "Full Game" : "DLC");
            game.setGameCompatibility(random.nextBoolean() ? "PS5" : "PS4");
            game.setEdition(random.nextBoolean() ? "STANDARD" : "DELUXE");
            game.setGameRating((int) round(random.nextDouble() * (5.0 - 3.0) + 3.0, 1));

            String jsonData = new Gson().toJson(game);

            String endPointUrl = "http://localhost:8091/api/v1/game/addGame";
            HttpEntity<GameDto> request = new HttpEntity<>(game);
            GameDto gameDto = this.restTemplate.postForObject(endPointUrl, request, GameDto.class);
            if(gameDto != null){
                System.out.println("Data inserted successfully for " + gameDto.getGameName());
            }

        }

    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        return Math.round(value * factor) / (double) factor;
    }


}
