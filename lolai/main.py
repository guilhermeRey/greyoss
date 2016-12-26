import random

from cassiopeia import riotapi

riotapi.set_region("BR")
riotapi.set_api_key("9bb95c2c-6d74-4b3b-911b-9fda01efc0db")



summoner = riotapi.get_summoner_by_name("Yarquen")
print("{name} is a level {level} summoner on the BR server." . format(name=summoner.name, level=summoner.level))

champions = riotapi.get_champions()
random_champion = random.choice(champions)
print("He enjoys playing LoL on all different champions, like {name}.".format(name=random_champion.name))

challenger_league = riotapi.get_challenger()
best_na = challenger_league[0].summoner
print("He's much better at writing Python code than he is at LoL. He'll never be as good as {name}.".format(name=best_na.name))
