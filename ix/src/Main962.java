import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
*	962 - Taxicab Numbers
*
*
*	Submision:	10311288
*	Date:		2012-07-09 16:20:07
*	Runtime:	0.640
*	Ranking:	295
*/
public class Main962 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException {
		int[] taxicab = { 1729, 4104, 13832, 20683, 32832, 39312, 40033, 46683,
				64232, 65728, 110656, 110808, 134379, 149389, 165464, 171288,
				195841, 216027, 216125, 262656, 314496, 320264, 327763, 373464,
				402597, 439101, 443889, 513000, 513856, 515375, 525824, 558441,
				593047, 684019, 704977, 805688, 842751, 885248, 886464, 920673,
				955016, 984067, 994688, 1009736, 1016496, 1061424, 1073375,
				1075032, 1080891, 1092728, 1195112, 1260441, 1323712, 1331064,
				1370304, 1407672, 1533357, 1566728, 1609272, 1728216, 1729000,
				1734264, 1774656, 1845649, 2048391, 2101248, 2301299, 2418271,
				2515968, 2562112, 2585375, 2622104, 2691451, 2864288, 2987712,
				2991816, 3220776, 3242197, 3375001, 3375008, 3511872, 3512808,
				3551112, 3587409, 3628233, 3798613, 3813992, 4033503, 4104000,
				4110848, 4123000, 4174281, 4206592, 4342914, 4467528, 4505949,
				4511808, 4607064, 4624776, 4673088, 4744376, 4914000, 4931101,
				5004125, 5135104, 5287707, 5318677, 5446359, 5462424, 5472152,
				5639816, 5772403, 5799339, 5832729, 5835375, 6013000, 6017193,
				6058747, 6230504, 6434883, 6445504, 6517000, 6742008, 7081984,
				7091712, 7094269, 7365384, 7620661, 7640128, 7872536, 7882245,
				7957504, 8029000, 8077888, 8131968, 8216000, 8275176, 8491392,
				8493039, 8494577, 8587000, 8600256, 8647128, 8741824, 8849601,
				8872487, 9016488, 9261729, 9443761, 9560896, 10036845,
				10083528, 10202696, 10424232, 10469816, 10589696, 10648512,
				10702783, 10765603, 10811017, 10821896, 10870119, 10962432,
				11097567, 11261376, 11478584, 11548089, 11557000, 11855727,
				11859211, 11985003, 12266856, 12533824, 12650337, 12753160,
				12874176, 13484016, 13489875, 13490533, 13623913, 13731319,
				13825728, 13832000, 13851000, 13874112, 13915125, 14197248,
				14482503, 14765192, 14916727, 14978061, 15077907, 15187041,
				15201368, 15398936, 15438250, 15682680, 16012269, 16387128,
				16387189, 16587207, 16776487, 16797375, 16809984, 16983854,
				17045567, 17999072, 18406603, 18410392, 18468513, 18617625,
				18673625, 19034379, 19250163, 19346168, 20072017, 20127744,
				20162952, 20496896, 20616463, 20683000, 20976832, 21036743,
				21125384, 21411000, 21531608, 21753576, 21994875, 22031576,
				22426369, 22543417, 22544704, 22754277, 22914304, 23901696,
				23934528, 24480125, 24666560, 24767171, 24858171, 24897817,
				25164405, 25371171, 25766208, 25785432, 25937576, 26122131,
				26506467, 26569809, 26856576, 27000008, 27000064, 27003375,
				27015625, 27262872, 27445392, 27529073, 27831951, 27882127,
				28094976, 28102464, 28149336, 28408896, 28658448, 28699272,
				28703269, 28981125, 29025864, 29184057, 29503656, 29791125,
				30388904, 30511936, 31256000, 32114143, 32268024, 32530680,
				32832000, 32886784, 32973759, 32984000, 33108264, 33394248,
				33652736, 34031907, 34743312, 35740224, 35938728, 36047592,
				36050904, 36094464, 36856512, 36998208, 37384704, 37498032,
				37955008, 38007144, 38253878, 39312000, 39448808, 39639691,
				40033000, 40134584, 40183262, 40354119, 40519115, 40970375,
				41080832, 41258737, 41301953, 41343640, 41400639, 41436873,
				41511232, 41892515, 42154840, 42168581, 42276843, 42301656,
				42549416, 43450344, 43570872, 43699392, 43777216, 43852536,
				43946000, 43997625, 44409995, 45118528, 45440551, 45882739,
				46091997, 46179224, 46343059, 46394712, 46661832, 46683000,
				46825128, 47915712, 48104000, 48137544, 48316662, 48469976,
				49832523, 49844032, 49849856, 49933368, 50324625, 51240427,
				51278929, 51479064, 51508639, 51564032, 52136000, 52242463,
				52324272, 52739288, 53226297, 53283923, 53936064, 54267003,
				54269091, 54814509, 54887625, 55306557, 55486125, 56388339,
				56655872, 56733696, 56754152, 57066633, 58438072, 58751784,
				58923072, 59913728, 60271939, 60698521, 60965288, 61121024,
				61555832, 61568208, 62108397, 62135073, 62980288, 63057960,
				63660032, 64125000, 64232000, 64421875, 64623104, 65055744,
				65272753, 65293317, 65573928, 65728000, 66201408, 66469429,
				66763333, 67173463, 67931136, 67944312, 67956616, 68007673,
				68696000, 68802048, 69177024, 69583995, 69625969, 69805125,
				69934592, 70449093, 70796808, 70957971, 70979896, 71292312,
				71509312, 72131904, 72669177, 73369088, 73819863, 73842713,
				74093832, 74097261, 74130875, 75550088, 76487168, 77129864,
				77335776, 77414967, 79598125, 79692193, 80102574, 80208576,
				80294760, 80668224, 80779032, 81621568, 83393856, 83758528,
				84266000, 84637287, 84717568, 85188096, 85492792, 85502375,
				85622264, 86124824, 86316741, 86368464, 86488136, 86575168,
				86960952, 87029432, 87483968, 87539319, 87579037, 87699456,
				87952501, 88122125, 88129323, 88780536, 89576767, 90091008,
				90527229, 91034307, 91125027, 91125216, 91140435, 91828672,
				92384712, 92456000, 94100426, 94820544, 94845816, 94873688,
				95547816, 95731489, 95880024, 96753187, 96860043, 97867441,
				97962291, 98040969, 98134848, 99768753, 100092456, 100270592,
				100711000, 101194704, 101202696, 101615579, 101700872,
				102025280, 102562551, 102977784, 102993408, 104212017,
				105343875, 105997327, 106243219, 106496767, 107872128,
				107919000, 107924264, 108904581, 108991304, 109850552,
				110087432, 110605824, 110656000, 110808000, 110992896,
				111321000, 111485673, 111906333, 112422709, 112705587,
				113577984, 114103808, 115084125, 115860024, 115942104,
				116215603, 116773741, 117132750, 117258678, 118121536,
				118129375, 118974960, 119082880, 119164409, 119333816,
				119377000, 119793457, 119824488, 120623256, 121287376,
				121496328, 121610944, 121660623, 121818816, 122262264,
				122810129, 123008375, 123191488, 123262120, 123506000,
				124336000, 124390728, 124868952, 125461440, 126173376,
				126217000, 126516061, 126906624, 127062000, 127396178,
				127525671, 128098152, 128966383, 129333078, 129380329,
				131097024, 131097512, 131126303, 131997229, 132678000,
				132697656, 133139727, 134171875, 134211896, 134379000,
				134479872, 135111375, 135870832, 136004184, 136364536,
				136591000, 137467603, 137854899, 138090771, 138647808,
				141117704, 141864697, 142098327, 142244648, 142768089,
				143604279, 143992576, 144370863, 144404416, 145461771,
				145908847, 146548376, 147051693, 147187369, 147252824,
				147283136, 147485448, 147748104, 148941000, 149389000,
				149496256, 150611643, 151212412, 152253927, 152275032,
				153444807, 154001304, 154245637, 154370456, 154573272,
				154769344, 155711528, 155722203, 155854881, 155916488,
				156234169, 156582153, 157366664, 157483683, 157555125,
				158818023, 159220431, 160576136, 161021952, 161303616,
				161801432, 162259704, 162351000, 162464211, 163586169,
				163753408, 163975168, 164931704, 165464000, 166205816,
				166383000, 166523877, 166560193, 167814656, 168170984,
				168196824, 168223608, 168293944, 169003072, 170138527,
				170479153, 171288000, 171904005, 172252864, 173741841,
				174028608, 175695507, 175959000, 176252608, 176427433,
				176662304, 176773625, 176992192, 178858449, 178871959,
				179105572, 179410952, 179421769, 179509967, 180314414,
				180347336, 180357632, 180526528, 180930169, 182034216,
				183314432, 185199859, 185840109, 186595201, 187551000,
				188239688, 188567470, 191213568, 191476224, 191545263,
				191669625, 192113857, 193139856, 195841000, 196682129,
				197332480, 197842337, 197915221, 198137368, 198156016,
				198836759, 198865368, 199182536, 199183563, 201159000,
				201315240, 202969368, 203415121, 204360858, 205556904,
				205757847, 205817976, 206129664, 206283456, 206471727,
				206491896, 206638712, 207500608, 207761337, 207879912,
				208977048, 209146357, 212051736, 212314473, 212558472,
				212820615, 214757361, 214852608, 216000064, 216000512,
				216027000, 216125000, 216226981, 216783000, 218102976,
				219563136, 220232584, 221832000, 221884299, 222636141,
				222655608, 223057016, 223429752, 223966106, 224759808,
				224819712, 225194688, 225696926, 227271168, 227984328,
				228613112, 229267584, 229312053, 229353579, 229594176,
				229626152, 230706125, 231638463, 231849000, 232116859,
				232206912, 233472456, 234618517, 236029248, 236893923,
				236933496, 237549907, 238328064, 238329000, 238396921,
				238939227, 239088213, 239557149, 239733108, 240643179,
				241668784, 241807111, 242054414, 243111232, 243445176,
				243578881, 244095488, 246930859, 247973427, 250048000,
				250066683, 251272359, 251650061, 253003625, 254079000,
				254981547, 255684520, 256048875, 256096512, 256913144,
				257408333, 258144192, 258453979, 259259832, 260016057,
				260245440, 260664371, 261243918, 262656000, 263094272,
				263790072, 263872000, 264866112, 265848219, 266818951,
				267153984, 269014473, 269221888, 269442621, 269641008,
				270994815, 271688534, 272255256, 272264167, 272449359,
				274220856, 274586347, 275472792, 276350984, 277946496,
				279487936, 281359449, 281454264, 281827000, 282078901,
				282685032, 282851784, 285921792, 287509824, 287531937,
				287662375, 288380736, 288407232, 288755712, 288975141,
				289063593, 290671281, 291897459, 292191192, 292768768,
				292940137, 293493213, 294852096, 295230663, 295484553,
				295985664, 296106165, 296889840, 299077632, 299457613,
				299634309, 299984256, 300694303, 300763729, 302283875,
				302709680, 303640064, 304057152, 306031024, 309921768,
				310030721, 310289733, 311798403, 312039000, 313186627,
				314496000, 315571816, 315590464, 315790839, 317117528,
				317347219, 318340736, 318769451, 320104629, 320198697,
				320264000, 320792192, 321076672, 321154048, 321466096,
				322832952, 322921664, 323171875, 323595081, 324152920,
				324159856, 324743922, 326296728, 326418309, 327570488,
				327763000, 328013504, 328112596, 328207633, 328646656,
				329986027, 330069896, 330415624, 330749120, 331205112,
				331433207, 331494984, 332089856, 332855432, 334260297,
				334746162, 335140120, 336431375, 336661488, 336732676,
				337238720, 337348648, 337534981, 338214744, 338413248,
				340395328, 340424721, 341177984, 341559099, 342019314,
				343884736, 344335320, 346061296, 346339448, 347602752,
				348326216, 348411511, 348566976, 348658128, 349595136,
				350217728, 350401842, 350775873, 350820288, 351568000,
				351981000, 352087784, 355100291, 355144257, 355279960,
				358036000, 360948224, 360959625, 363524408, 364068432,
				364226625, 364244391, 365268976, 367061912, 367845651,
				368167625, 368735976, 369433792, 370744472, 370745613,
				371157696, 371465101, 372046239, 372243384, 372525543,
				373294656, 373333697, 373464000, 373977000, 374601024,
				374805704, 375708375, 376319736, 383131728, 383325696,
				384832000, 385100352, 386533296, 387352719, 387759808,
				388481697, 389675503, 391027581, 391386736, 392450149,
				398660184, 398752256, 398798848, 398974437, 399094696,
				399466944, 401947273, 402597000, 402751629, 404407647,
				405274625, 406767816, 407103489, 409923416, 410050107,
				410231432, 410436936, 411832512, 412069112, 412512256,
				414723456, 415771272, 416318561, 416832750, 417088000,
				417939704, 418594176, 420926779, 421875125, 421876000,
				421914304, 422050616, 423432360, 423638839, 423842013,
				425559771, 425810376, 426089592, 426271384, 428805377,
				429396751, 430262677, 431488512, 431685072, 432331263,
				432597529, 434136024, 434152728, 436252553, 437440591,
				438516072, 438984000, 439003000, 439101000, 440231463,
				440567288, 441133299, 441912051, 442174376, 442452456,
				442454103, 442962728, 443889000, 446110119, 446686147,
				447854589, 447902504, 448426125, 448675416, 449398952,
				449519625, 449806912, 450680139, 450828352, 451106712,
				452965149, 453246976, 453474775, 453529125, 453869568,
				454033216, 455060032, 456533064, 456554952, 458314038,
				458314136, 458564058, 460230309, 463085632, 467504576,
				470014272, 471384576, 474611319, 474826625, 475676864,
				476749000, 478309104, 478378143, 479309824, 482175512,
				482831496, 483634125, 483772562, 485587720, 485588168,
				485974944, 487081511, 487722304, 488968192, 491019633,
				491935528, 492446656, 492545664, 494935623, 496867176,
				496978281, 497080584, 497322728, 498018131, 498649851,
				502675875, 502866152, 503842304, 504187875, 504437687,
				504463680, 506456685, 508947192, 509280256, 509869171,
				510105141, 510200217, 513000000, 513856000, 513926497,
				513928233, 514580904, 515375000, 516984832, 519754401,
				520019227, 520445952, 521785125, 522182024, 522346536,
				524591424, 525824000, 525941451, 529611264, 529725176,
				529790616, 531755432, 532918080, 534106664, 535856607,
				536214952, 537387704, 538922251, 539385912, 540746696,
				541944459, 542532536, 542864250, 543449088, 543543875,
				543554496, 543652928, 544061384, 544399704, 546106141,
				547874873, 549568000, 550416384, 551525464, 551674179,
				551980296, 553416192, 553423598, 553514689, 556644501,
				556671960, 556913233, 557007752, 558164672, 558441000,
				559476736, 563243625, 563592744, 563976000, 566069497,
				566374464, 567663768, 567839168, 567992061, 568483496,
				570338496, 570385368, 572074496, 574002793, 575047207,
				575883000, 577055232, 578097000, 579186127, 581251329,
				581353416, 584136000, 584443431, 584504191, 586377981,
				586952704, 587346552, 590421637, 590558904, 590741704,
				590816259, 592750656, 592778088, 593047000, 593861625,
				594852552, 596636137, 599881464, 601783371, 604400704,
				605511963, 606932928, 608672259, 608707008, 610096697,
				610475129, 610991208, 611897344, 612063872, 614250000,
				614365479, 616167253, 616387625, 617038912, 618686208,
				618828119, 619319736, 619977176, 624594789, 625515625,
				625598162, 626125248, 626791256, 627085333, 632767581,
				633057607, 634207392, 634314331, 635551280, 636060096,
				636785000, 637537544, 639370108, 640820592, 641668608,
				641888000, 642358080, 645292648, 645345792, 646232256,
				646925832, 649923463, 652972544, 655802784, 658534877,
				660204027, 660715272, 660963375, 661358061, 662752125,
				664834625, 665338625, 665365617, 665997120, 667150848,
				668713617, 670068224, 671170617, 672241059, 672610393,
				674128000, 674922086, 677098296, 677740544, 679151503,
				679346551, 679438935, 680794875, 681504768, 682333749,
				682803000, 683942336, 684019000, 684329282, 684978112,
				685021617, 685726587, 685964125, 687013704, 687925719,
				688485070, 688998592, 689406579, 690533928, 690947712,
				691905088, 692102133, 692601344, 692612137, 693088669,
				694919869, 695687616, 696206664, 696235456, 696330648,
				699871744, 700314552, 700632296, 701595648, 702197585,
				702598113, 702669457, 703620008, 704977000, 705034584,
				705297537, 708493743, 709254728, 710244288, 711071846,
				715674609, 716614136, 717384843, 719323479, 720095311,
				720728064, 721550375, 722366073, 724217832, 724917375,
				725127552, 725545539, 728274456, 729000216, 729001728,
				729091125, 729123480, 729328509, 729418816, 729421875,
				729577063, 730549099, 733204262, 733948157, 734629376,
				736097544, 739077696, 739648000, 741025584, 741557943,
				743284971, 743693041, 744214049, 746037808, 751462677,
				751625000, 752149125, 752314472, 752803408, 752817429,
				753589286, 755857466, 757343375, 758564352, 758766528,
				758989504, 760032072, 762265231, 764382528, 765851912,
				767040192, 771870736, 773778096, 774025496, 774880344,
				774988263, 777153663, 778813000, 779733136, 781510744,
				781572961, 782490375, 782924203, 782939528, 783698328,
				783982827, 784327752, 784342097, 784556136, 785078784,
				787969539, 788197832, 788964463, 788966919, 789006673,
				789229224, 789345557, 790203951, 796598712, 798150024,
				799214689, 799712576, 800739648, 801584856, 802164736,
				804360375, 805688000, 806672113, 809048385, 809557632,
				809621568, 809886077, 812924632, 813357253, 813606976,
				814252257, 814414328, 814625000, 816202240, 817638703,
				820500408, 820735552, 822741192, 823822272, 823947264,
				825682689, 825822144, 829466953, 833696136, 841283037,
				841537944, 842751000, 842875416, 843912000, 845973423,
				846635517, 847691136, 847978616, 849829491, 849945752,
				851974136, 852464431, 858849608, 860616792, 862977024,
				863352000, 863394112, 867081861, 871236648, 871930432,
				878328360, 878804416, 880699456, 884505609, 884846592,
				885156363, 885248000, 885818304, 885950533, 886464000,
				886783625, 887943168, 890291493, 890336447, 890568000,
				891885384, 893923128, 895250664, 898412697, 899381672,
				900810729, 901644696, 902604339, 902719944, 907301376,
				908623872, 908992357, 910429289, 911298661, 912830464,
				918496423, 918861489, 920673000, 921705561, 923062959,
				923167693, 924151032, 924503463, 924845103, 925299648,
				926880192, 927050059, 927536832, 929724824, 929783582,
				929846827, 930935059, 931530024, 932678656, 934189928,
				935181611, 937062000, 937714176, 938069424, 938324387,
				940917887, 944002423, 944972288, 945035000, 948409065,
				948673971, 950859559, 951799680, 952582625, 952663040,
				953315272, 954193392, 954670528, 955016000, 957847527,
				958347656, 958590477, 958595904, 958657609, 958780368,
				959281759, 959795109, 960429545, 962166833, 964598327,
				964704897, 964986048, 970168752, 970299008, 970345656,
				970765803, 971970624, 972448841, 972887552, 973243000,
				973284984, 973288927, 973374408, 974550528, 975224133,
				976364837, 978098112, 979428329, 982450784, 982481032,
				982797192, 984067000, 985280625, 985531904, 986096960,
				988048000, 988619723, 989950464, 994688000, 995125824,
				996762312, 998951616, 1003625000, 1003691520, 1005375880,
				1009736000, 1012128488, 1013167629, 1013396293, 1015252992,
				1015438249, 1016496000, 1027000000 };
		int a, b, i;
		Scanner input = new Scanner(System.in);
		boolean found;

		while (input.hasNext()) {
			found = false;
			a = input.nextInt();
			b = input.nextInt() + a;
			i = 0;
			while (taxicab[i] < a)
				i++;
			while (taxicab[i] <= b) {
				System.out.println(taxicab[i]);
				found = true;
				i++;
			}
			if (!found)
				System.out.println("None");
		}
		input.close();
	}
}