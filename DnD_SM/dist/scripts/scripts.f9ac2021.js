function config($stateProvider,$urlRouterProvider){$urlRouterProvider.otherwise("/index/main"),$stateProvider.state("pc",{url:"/pc",templateUrl:"views/common/raw.html"}).state("pc.scene",{url:"/realtime",templateUrl:"views/pcscene.html",controller:SceneCtrl}).state("index",{"abstract":!0,url:"/index",templateUrl:"views/common/content.html"}).state("index.main",{url:"/main",templateUrl:"views/main.html",data:{pageTitle:"Example view"}}).state("index.adventure",{url:"/adventure?id",templateUrl:"views/adventure.html",controller:AdventureCtrl}).state("index.scene",{url:"/scene?id",templateUrl:"views/scene.html",controller:SceneController})}function pageTitle($rootScope,$timeout){return{link:function(scope,element){var listener=function(event,toState,toParams,fromState,fromParams){var title="D&D DM Shield";toState.data&&toState.data.pageTitle&&(title="INSPINIA | "+toState.data.pageTitle),$timeout(function(){element.text(title)})};$rootScope.$on("$stateChangeStart",listener)}}}function sideNavigation($timeout){return{restrict:"A",link:function(scope,element){$timeout(function(){element.metisMenu()})}}}function iboxTools($timeout){return{restrict:"A",scope:!0,templateUrl:"views/common/ibox_tools.html",controller:function($scope,$element){$scope.showhide=function(){var ibox=$element.closest("div.ibox"),icon=$element.find("i:first"),content=ibox.find("div.ibox-content");content.slideToggle(200),icon.toggleClass("fa-chevron-up").toggleClass("fa-chevron-down"),ibox.toggleClass("").toggleClass("border-bottom"),$timeout(function(){ibox.resize(),ibox.find("[id^=map-]").resize()},50)},$scope.closebox=function(){var ibox=$element.closest("div.ibox");ibox.remove()}}}}function minimalizaSidebar($timeout){return{restrict:"A",template:'<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="" ng-click="minimalize()"><i class="fa fa-bars"></i></a>',controller:function($scope,$element){$scope.minimalize=function(){$("body").toggleClass("mini-navbar"),!$("body").hasClass("mini-navbar")||$("body").hasClass("body-small")?($("#side-menu").hide(),setTimeout(function(){$("#side-menu").fadeIn(500)},100)):$("body").hasClass("fixed-sidebar")?($("#side-menu").hide(),setTimeout(function(){$("#side-menu").fadeIn(500)},300)):$("#side-menu").removeAttr("style")}}}}function watchPosition($timeout){return{link:function(scope,element){scope.$watch(function(){return{top:element.css("top"),left:element.css("left")}},function(newValue){console.log(newValue),scope.scene.current.grid={top:element.css("top")}})}}}function MainCtrl($scope,$interval){var db=DnD.DB.instance().dbcontext("DnD");this.dungeonMaster={name:"Guilherme Rey",email:"poli.rey@gmail.com"},this.game=new DungeonsAndDragons(DnD.game),$scope.config={full:!1},this.toggleConfigView=function(){$scope.config.full=!$scope.config.full},this.playerAction=function(player,expr){eval(expr),db.save("current-players",JSON.stringify(this.game.players))}}function AdventureCtrl($scope,$stateParams,$interval){var db=DnD.DB.instance().dbcontext("DnD");$scope.id=$stateParams.id,$scope.game=DnD.loadCampaign(),$scope.current={adventure:$scope.game.AdventureById($scope.id)},db.save("game",JSON.stringify($scope.game)),db.save("current.adventure",JSON.stringify($scope.current.adventure)),$scope.selectScene=function(scene){$scope.current.scene=scene,db.save("game",JSON.stringify($scope.game)),db.save("current.scene",JSON.stringify($scope.currentScene)),db.save("current-players",JSON.stringify($scope.game.players))}}function SceneController($scope,$stateParams,$interval,$timeout){var db=DnD.DB.instance().dbcontext("DnD"),sceneidx=parseInt($stateParams.id);$scope.init=function(){$scope.game=JSON.parse(db.where("game")),$scope.adventure=JSON.parse(db.where("current.adventure")),$scope.scene=$scope.adventure.scenes[sceneidx],$scope.rolls=[],$scope.isRolling=!1,$scope.scene.current={music:$scope.scene.musics[0],monster:"",grid:{top:"",left:"",zoom:"600%"},mode:"normal",combat:{turns:[],initiative:[]},menus:{library:{show:!0,isTab:!0},tools:{show:!1,isTab:!0},combat:{show:!1,isTab:!0},monsters:{show:!1,isTab:!1},npcs:{show:!1,isTab:!1},items:{show:!1,isTab:!1}},dungeon:{monsters:[],npcs:[],items:[]}},$scope.previous=sceneidx>0?$scope.adventure.scenes[sceneidx-1]:{name:""},$scope.next=sceneidx<$scope.adventure.scenes.length-1?$scope.adventure.scenes[sceneidx+1]:{name:""},$scope.previous.id=sceneidx-1,$scope.next.id=sceneidx+1,$interval(function(){db.save("current-grid",$("<div>").append($("#dungeon-grid").clone()).html()),db.save("current-monster",$scope.scene.current.monster),db.save("current-mode",$scope.scene.current.mode),db.save("current-turns",$("<div>").append($("#turns").clone()).html())},500),$timeout(function(){$(".draggable").draggable({containment:"parent"}),$("#grid-slider-square-guide").on("input",function(){var $miniMap=$("#grid-minimap"),w_m=$miniMap.width(),h_m=$miniMap.height(),$this=$(this),w=parseFloat($this.val()*w_m/100).toFixed(2),h=parseFloat($this.val()*h_m/100).toFixed(2),z_bg_w=w_m/w*100;z_bg_h=h_m/h*100,$("#dungeon-grid").css("background-size",z_bg_w+"% "+z_bg_h+"%"),$("#grid-square-guide").css("width",w).css("height",h)}),$("#grid-square-guide").draggable({containment:"parent",drag:function(e,ui){var target=$("#"+ui.helper.data("target-grid")),h_m=parseFloat(ui.helper.parent().height()),w_m=parseFloat(ui.helper.parent().width()),t_p=ui.position.top/h_m*100,l_p=ui.position.left/w_m*100,gridBgPos=target.css("background-size").split(" "),bgPos={x:parseFloat(gridBgPos[1].replace("%","")),y:parseFloat(gridBgPos[0].replace("%",""))},x=target.width(),y=target.height(),w=x*bgPos.x/100,h=y*bgPos.y/100,bgx=l_p/100*w,bgy=t_p/100*h;target.css("background-position",-bgx+"px "+-bgy+"px")}})},500)},$scope.uncombat=function(){$scope.scene.current.mode="normal",$scope.scene.current.combat.turns=[],$scope.scene.current.combat.initiative=[]},$scope.defineTurns=function(){$scope.scene.current.combat.initiative=_.sortBy($scope.scene.current.combat.initiative,function(o){return-o.initiative}),_.each($scope.scene.current.combat.initiative,function(e){$scope.scene.current.combat.turns.push({subject:e.subject,active:!1})}),$scope.scene.current.combat.turns[0].active=!0,$scope.scene.current.combat.initiative=[]},$scope.nextTurn=function(){for(var i=0;i<$scope.scene.current.combat.turns.length;i++)if($scope.scene.current.combat.turns[i].active){$scope.scene.current.combat.turns[i].active=!1,$scope.scene.current.combat.turns[(i+1)%$scope.scene.current.combat.turns.length].active=!0;break}},$scope.combat=function(){$scope.scene.current.mode="combat",$scope.scene.current.combat.turns=[],$scope.scene.current.combat.initiative=[],_.each($scope.game.players,function(e){$scope.scene.current.combat.initiative.push({subject:e,initiative:0})}),_.each($scope.scene.current.dungeon.monsters,function(m){$scope.scene.current.combat.initiative.push({subject:m,initiative:0})})},$scope.tab=function(tabName){for(var menu in $scope.scene.current.menus)$scope.scene.current.menus[menu].isTab&&($scope.scene.current.menus[menu].show=!1);$scope.scene.current.menus[tabName].show=!0},$scope.toggleMenu=function(obj){obj.show=!obj.show},$scope.refreshMonsters=function(){$scope.scene.current.dungeon.monsters=[]},$scope.hit=function(subject){subject.hp--},$scope.addDraggableItemToGrid=function(arr,obj){arr.push(obj),$timeout(function(){$(".draggable").draggable({containment:"parent"})},1e3)},$scope.addNPC=function(npc){var newNpc={name:npc.name,hp:npc.hp};$scope.addDraggableItemToGrid($scope.scene.current.dungeon.npcs,newNpc)},$scope.addMonster=function(monster){var newMonster={name:monster.name+" "+(parseInt($scope.scene.current.dungeon.monsters.length)+1),hp:monster.hp};$scope.addDraggableItemToGrid($scope.scene.current.dungeon.monsters,newMonster)},$scope.dropped=function(dragEl,dropEl){var drag=$("#"+dragEl),drop=$("#"+dropEl);drop.css("background-color",drag.attr("data-color")),drop.text(drag.attr("data-drop-name")),drop.attr("data-color",drag.attr("data-color")),drop.attr("x-lvl-draggable","true"),drag.attr("x-lvl-drop-target")&&drag.css("background-color","rgba(255, 255, 255, 0.3)")},$scope.music=function(m){$scope.scene.current.music=m},$scope.initiativeRoll=function(modifier){$scope.rollDice("Iniciativa (1d20 + "+modifier+")",Dice.damage("1d20")())},$scope.damageRoll=function(spell){$scope.rollDice(spell.name+" ("+spell.damage+")",Dice.damage(spell.damage)())},$scope.roll=function(dice){$scope.rollDice(dice,Dice.damage(dice)())},$scope.rollDice=function(d,r){$scope.isRolling=!0,$("#dice-roll-sound").on("click",function(){this.play()}),$("#dice-roll-sound").trigger("click"),$timeout(function(){$scope.rolls.push({text:d,result:r}),$scope.isRolling=!1},1200)}}function SceneCtrl($scope,$stateParams,$interval,$timeout){var db=DnD.DB.instance().dbcontext("DnD"),w=$(window).width(),h=$(window).height();$("#table-canvas").css("width",w).css("height",h),$("#img-shield").css("width",w).css("height",h),$scope.currentWindow={width:$(window).width(),height:$(window).height()},$interval(function(){var w=$(window).width(),h=$(window).height();$("#table-canvas").css("width",w).css("height",h),$("#img-shield").css("width",w).css("height",h)},1e4),$interval(function(){$("#canvas").html(db.where("current-grid")),$("#turns").html(db.where("current-turns")),$scope.mode=db.where("current-mode")},500),$interval(function(){var players=JSON.parse(db.where("current-players"));$scope.players=[],_.each(players,function(e){$scope.players.push(new Player(e))})},1e3)}$(document).ready(function(){function fix_height(){var heightWithoutNavbar=$("body > #wrapper").height()-61;$(".sidebard-panel").css("min-height",heightWithoutNavbar+"px");var navbarHeigh=$("nav.navbar-default").height(),wrapperHeigh=$("#page-wrapper").height();navbarHeigh>wrapperHeigh&&$("#page-wrapper").css("min-height",navbarHeigh+"px"),wrapperHeigh>navbarHeigh&&$("#page-wrapper").css("min-height",$(window).height()+"px")}jQuery.event.props.push("dataTransfer"),$(window).bind("load resize scroll",function(){$("body").hasClass("body-small")||fix_height()}),setTimeout(function(){$(".draggable").draggable({containment:"parent"})},500),setTimeout(function(){fix_height()}),setTimeout(function(){$(".grid").each(function(){return})},1200)}),$(function(){$(window).bind("load resize",function(){$(this).width()<769?$("body").addClass("body-small"):$("body").removeClass("body-small")})});var DnDHelper={getMap:function(fileName){return"app/dnd_resources/maps/"+fileName}},Dice={roll:function(qt,faces){for(var rolls=[],i=0;qt>i;i++)rolls.push(Math.floor(Math.random()*faces+1));return rolls.reduce(function(a,b){return a+b})},damage:function(dmg){for(var dices=[],i=0;i<dmg.length;i++)if("D"!=dmg[i].toUpperCase());else{dmg[i]="d";for(var diceQty="",diceType="",j=i,k=i;void 0!==dmg[--j]&&!isNaN(dmg[j]);)diceQty+=dmg[j];for(;void 0!==dmg[++k]&&!isNaN(dmg[k]);)diceType+=dmg[k];diceQty=parseInt(diceQty),diceType=parseInt(diceType),dices.push({name:"d"+diceType,faces:diceType,quantity:diceQty,exp:diceQty+"d"+diceType,evalExp:"Dice.roll("+diceQty+", "+diceType+")"}),i=k}for(var l=0;l<dices.length;l++)dmg=dmg.replace(dices[l].exp,dices[l].evalExp);return function(){return eval(dmg)}}},DungeonsAndDragons=function(args){var me=this;this.name=args.name,me.players=[],me.adventures=[],me.world=args.world,_.each(args.players,function(e){me.players.push(new Player(e))}),_.each(args.adventures,function(a){me.adventures.push(new Adventure(a))}),this.AdventureById=function(idToFind){var search={id:parseInt(idToFind)};return _.findWhere(me.adventures,search)}},Player=function(args){this.name=args.name,this.age=args.age,this.sex=args.sex,this.height=args.height,this.weigth=args.weigth,this.favoriteWeapon=args.favoriteWeapon,this.alignment=args.alignment,this.history=args.history,this.ability={dex:args.dex||0,con:args.con||0,"int":args["int"]||0,wis:args.wis||0,cha:args.cha||0},this.ac=args.ac,this.initiative=args.initiative,this.hp=args.hp,this.currentHp=args.currentHp||this.hp,this.restore=function(torestore){torestore+this.currentHp>this.hp?this.currentHp=this.hp:this.currentHp+=torestore},this.hit=function(damage){this.currentHp-=damage},this.php=function(){return parseFloat(100*this.currentHp/this.hp).toFixed(2)},this.currentColorHp=function(){var hpPercentage=this.php();return 25>=hpPercentage?"red-bg":65>=hpPercentage?"yellow-bg":"navy-bg"}},Adventure=function(args){if(this.id=args.id,this.name=args.name,this.description=args.description,this.scenes=[],args.scenes&&args.scenes.length>0)for(var i=0;i<args.scenes.length;i++)this.scenes.push(new Scene(args.scenes[i]))},Scene=function(args){this.name=args.name,this.description=args.description,this.location=new Location(args.location),this.dungeon=new Dungeon(args.dungeon||{maps:[]}),this.npcs=args.npcs,this.monsters=args.monsters,this.musics=args.musics,this.positions=[]},Location=function(options){this.name=options.name,this.map=options.map},Dungeon=function(options){this.maps=options.maps||[]};!function(){angular.module("inspinia",["ui.router","ui.bootstrap"])}(),angular.module("inspinia").config(config).run(function($rootScope,$state){$rootScope.$state=$state}),angular.module("inspinia").factory("uuid",function(){var svc={"new":function(){function _p8(s){var p=(Math.random().toString(16)+"000000000").substr(2,8);return s?"-"+p.substr(0,4)+"-"+p.substr(4,4):p}return _p8()+_p8(!0)+_p8(!0)+_p8()},empty:function(){return"00000000-0000-0000-0000-000000000000"}};return svc}).directive("pageTitle",pageTitle).directive("sideNavigation",sideNavigation).directive("iboxTools",iboxTools).directive("minimalizaSidebar",minimalizaSidebar).directive("lvlDraggable",["$rootScope","uuid",function($rootScope,uuid){return{restrict:"A",link:function(scope,el,attrs,controller){console.log("linking draggable element"),angular.element(el).attr("draggable","true");var id=attrs.id;attrs.id||(id=uuid["new"](),angular.element(el).attr("id",id)),el.bind("dragstart",function(e){e.dataTransfer.setData("text",id),$rootScope.$emit("LVL-DRAG-START")}),el.bind("dragend",function(e){$rootScope.$emit("LVL-DRAG-END")})}}}]).directive("lvlDropTarget",["$rootScope","uuid",function($rootScope,uuid){return{restrict:"A",scope:{onDrop:"&"},link:function(scope,el,attrs,controller){var id=attrs.id;attrs.id||(id=uuid["new"](),angular.element(el).attr("id",id)),el.bind("dragover",function(e){return e.preventDefault&&e.preventDefault(),e.dataTransfer.dropEffect="move",!1}),el.bind("dragenter",function(e){angular.element(e.target).addClass("lvl-over")}),el.bind("dragleave",function(e){angular.element(e.target).removeClass("lvl-over")}),el.bind("drop",function(e){e.preventDefault&&e.preventDefault(),e.stopPropogation&&e.stopPropogation();var data=e.dataTransfer.getData("text");document.getElementById(id),document.getElementById(data);scope.onDrop({dragEl:data,dropEl:id})}),$rootScope.$on("LVL-DRAG-START",function(){var el=document.getElementById(id);angular.element(el).addClass("lvl-target")}),$rootScope.$on("LVL-DRAG-END",function(){var el=document.getElementById(id);angular.element(el).removeClass("lvl-target"),angular.element(el).removeClass("lvl-over")})}}}]);var LocalStorageDb=function(){this.context="",this.seq=1,this.key=function(keyname){return[this.context,keyname||this.seq++].join(".")}};LocalStorageDb.prototype.save=function(keyName,obj){return localStorage.setItem(this.key(keyName),obj),this},LocalStorageDb.prototype.dbcontext=function(contextName){return this.context=contextName,this},LocalStorageDb.prototype.where=function(keyName){return localStorage.getItem(this.key(keyName))};var DnD={game:{name:"Campanha de Garth",players:[{name:"Sir Eriah",ac:16,initiative:4,hp:11,age:"33",sex:"Male",height:"1.85",weight:"90",favoriteWeapon:"long sword",alignment:"lawful good",history:"Sir Eriah, vem de uma familia humilde. Seu pai, Ludwing, um ex-soldado real e hoje ferreiro aposentado, sempre fez questão de               educar seu filho (de maneira rigida demais) para que seguisse um caminho diferente do seu e tivesse sucesso na vida(dinheiro).               Desde pequeno Eriah passava os dias estudando religião e cultura na fazenda onde moravam. Sua mãe, Amélia, uma agricultora da local,               vendia hortaliças para sustentar a familia nos longos periodos que Ludwing passava fora em guerras ou missões.               Quando tinha 8 anos, Eriah passou pela experiencia que iria transformar sua vida.               Em uma noite escura, Eriah acorda assustado ouvindo gritos em sua janela, quando ele olha, ve seu pai lutando bravamente               contra um bando de orcs saqueadores.               Eriah, que não havia sido treinado em combate junta suas forças em meio as lagrimas e ora ao seu Deus Heironeous, Deus do heroismo,               para que salve sua familia, e então como magica um grande barulho é ouvido e um clarão ilumina as plantações, como um trovão caindo               do céu, Eriah ve a mão de Heironeous caindo sobre os bandidos e espalhando fogo em algumas plantas.               Isso foi suficiente para espantar os orcs incredulos e salvar sua familia. Mas não sem causar estragos. Seu pai acaba por sofrer um               corte durante a luta e perde a perna (motivo de se tornar um ferreiro).                Eriah acredita que Heironeuous o salvou pois tinha uma missão a ser cumprida e deveria se tornar um soldado do Deus.               Então se engaja em treinar com seu pai e posteriormente com cavaleiros templarios, onde foi obrigado a abandonar seus pais para               se especializar no treinamento, que era divido em combate e fé. Após os 19 anos, com o sucesso de sua primeira missão de fé,               recebe o titulo de Sir.               Hoje Sir Eriah tem como objetivo espalhar a palavra e a força de Heironeus para os indefesos e destruir toda e qualquer fonte do mal."},{name:"Beren",ac:15,initiative:7,hp:7,age:"35",sex:"Male",height:"1.80",weight:"75",favoriteWeapon:"bow and arrow",race:"hald-elf",claz:"bugler",alignment:"chaotic neutral",history:"Berem é filho de uma elfa com um humano ladino, que foi contratado para matar sua mãe, mas eles acabaram se apaixonando e ficaram juntos.               Seu avô descobriu a intenção inicial de seu pai e acabou assassinando-o. Sua mãe faleceu ao dar a luz a Beren, logo Beren foi criado pelo avô.               Com 10 anos Beren mata seu avô, por ele ser um escravocrata e tratá-lo como bastardo. Um andarilho encontrou Beren, e reconhecendo o colar de seu Pai acabou por levá-lo para a Guilda de assassinos."},{name:"Meitán Pifu",ac:15,initiative:2,hp:9,age:"28",sex:"Male",height:"1.70",weight:"60",favoriteWeapon:"besta",race:"humano",claz:"monge",alignment:"lawful neutral",history:""},{name:"Argoth Greymane",ac:18,initiative:2,hp:11,age:"150",sex:"Male",height:"1.64",weight:"120",favoriteWeapon:"double handed axe",race:"anão",claz:"guerreiro",alignment:"chaotic neutral",history:""}],world:{name:"Garth",map:"maps/worldmap.png"},adventures:[{id:1,name:"IV CAF",description:"Os heróis precisam viajar até o país de ESTROV, onde ocorre o IV CAF e conseguir informações sobre uma possível conspiração para guerra.",scenes:[{name:"O encontro na taverna",description:"O grupo se encontra na taverna",location:{name:"Taverna",map:"dnd_resources/maps/tavern.jpg"},npcs:[],monsters:[],musics:[]},{name:"Reunião no QG",description:"O grupo de heróis se encontra com o guarda real para negociar sobre o suposto trabalho",location:{name:"QG da Guarda Real",map:"maps/tabern.png"},npcs:[],monsters:[],musics:[]},{name:"Viagem para Estrov",description:"O grupo de heróis se encontra com o guarda real para negociar sobre o suposto trabalho",location:{name:"QG da Guarda Real",map:"dnd_resources/maps/forest.jpg"},npcs:[],monsters:[],musics:[]},{name:"Chegando em Estrov",description:"A cidade de Theogonia, a capital de Estrov, é uma cidade de humanos que possui grande número populacional",location:{name:"Estrov",map:"dnd_resources/maps/estrov.jpg"},npcs:[],monsters:[],musics:[]},{name:"IV CAF",description:"",location:{name:"Estrov",map:"dnd_resources/maps/castle.jpg"},npcs:[],monsters:[],musics:[]},{name:"IV CAF - Group Rounds - Dungeons",description:"",location:{name:"CAF Dungeon",map:"dnd_resources/maps/first_dungeon.png"},npcs:[],monsters:[{name:"Beholder",image:"dnd_resources/monsters/beholder.jpg",ac:12,hp:11,initiative:0,weapon:null,spells:[{name:"Eye Ray",damage:"2d4 + 2"}],instances:[1,2,3]}],musics:[{name:"Dungeon",file:"dnd_resources/musics/65_Dungeon_I.mp3"}]},{name:"IV CAF - Group Rounds - Dungeons - Segundo Nível",description:"Uma caverna sombria e gélida, com rochas firmes e úmidas",location:{name:"CAF Dungeon - Level 2",map:"dnd_resources/maps/dungeon2.jpg"},npcs:[{name:"Elfo Amigo",image:"",ac:15,hp:7,initiative:3,hits:[{name:"Arco e Flecha",damage:"1d8"}]},{name:"Elfa Amiga",image:"",ac:15,hp:9,initiative:3,hits:[{name:"Adaga Dupla",damage:"2d4"}]}],monsters:[{name:"Beholder",image:"dnd_resources/monsters/beholder.jpg",ac:12,hp:11,initiative:0,weapon:null,spells:[{name:"Eye Ray",damage:"2d4 + 2"}]},{name:"Skeleton Warrior",image:"dnd_resources/monsters/skeleton_warrior.jpg",ac:14,hp:18,initiative:0,weapon:null,spells:[{name:"Club Punch",damage:"1d4 + 2"}]},{name:"Skeleton Archer",image:"dnd_resources/monsters/skeleton_archer.jpg",ac:11,hp:15,initiative:3,weapon:null,spells:[{name:"Fire Arrow",damage:"1d6 + 1"}]},{name:"Necromancer",image:"dnd_resources/monsters/necromancer.jpg",ac:13,hp:45,initiative:3,weapon:null,spells:[{name:"Shadow Ball",damage:"1d6"},{name:"Reviver Esqueleto",damage:"1d8"}]}],musics:[{name:"Dungeon",file:"dnd_resources/musics/65_Dungeon_I.mp3"}]}]}]},loadCampaign:function(campaignId){return new DungeonsAndDragons(DnD.game)},DB:{_instance:null,instance:function(){return null===DnD.DB._instance&&(DnD.DB._instance=new LocalStorageDb),DnD.DB._instance}}};angular.module("inspinia").controller("MainCtrl",MainCtrl);