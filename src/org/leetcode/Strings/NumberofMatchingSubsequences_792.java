package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.junit.Test;

public class NumberofMatchingSubsequences_792 {

  public int numMatchingSubseq(String S, String[] words) {
    int number = 0;
    Map<Character, TreeSet<Integer>> sMap = new HashMap<>();

    for (int i = 0; i < S.length(); i++) {
      TreeSet treeSet = sMap.getOrDefault(S.charAt(i), new TreeSet());
      treeSet.add(i);
      sMap.put(S.charAt(i), treeSet);
    }

    for (String word : words) {
      Integer index = -1;

      for (int i = 0; i < word.length(); i++) {
        if (!sMap.containsKey(word.charAt(i))) {
          break;
        }
        index = sMap.get(word.charAt(i)).ceiling(index);
        if (index == null) {
          break;
        } else {
          index++;
        }

        if (i == word.length() - 1) {
          number++;
        }
      }

    }

    return number;
  }


  @Test
  public void test1() {
    System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
  }

  @Test
  public void test2() {
    System.out.println(
        numMatchingSubseq("dsahjpjauf", new String[]{"ja", "ahjpjau", "ahbwzgqnuk", "tnmlanowax"}));
  }


  @Test
  public void test3() {
    System.out.println(
        numMatchingSubseq(
            "ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd",
            new String[]{"iowuuudrgzmw", "azfcxtvhkruvuturdicnucvndigovkzrq", "ylmmo",
                "maptilrbfpjxiarmwalhbd", "oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl",
                "ytldcdlxqbaszbuxsacqwqnhrewhagldzhr", "zeeab", "cqie",
                "pvrazfcxtvhkruvuturdicnucvndigovkzrqiya", "zxnvpluwicurrtshyvevkriudayyysepzq",
                "wyhxltligahroyshfn", "nhrewhagldzhryzdmmrwn",
                "yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw", "nhrptuugyfsghluythksqhmxlmggtcbdd",
                "yligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjsc",
                "zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq",
                "ncygycdpehteiugqbptyqbvokpwovbnplshnzafun", "gdzutwgjofowhryrubnxkahocqjzww",
                "eppapjoliqlhbrbgh", "qwhgobwyhxltligahroys", "dzutwgjofowhryrubnxkah",
                "rydhxkdhffyytldcdlxqbaszbuxs", "tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc",
                "khvyjyrydhxkdhffyytldcdlxqbasz", "jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn",
                "ppapjoliqlhbrbghq", "zmwwxzjckmaptilrbfpjxiarm", "nxkahocqjzwwagqidjhwbunvlchoj",
                "ybfxpvqywqjdlyznmojdhbeomyjqptltp", "udrgzmwnxae", "nqglnpjvwddvdlmjjyzmww",
                "swlvtlbmkrsurrcsgdzutwgjofowhryrubn", "hudqbfnzxnvpluwicurr", "xaezuqlsfvchjf",
                "tvibbwxnokzkhndmdhweyeycamjeplec", "olnswlvtlbmkrsurrcsgdzu",
                "qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt",
                "eiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwyl", "cgiowuuudrgzmwnxaezuqlsfvchjflocz",
                "rxric", "cygycdpehteiugqbptyqbvokpwovbnplshnzaf", "g", "surrcsgd",
                "yzenflfnhrptuugyfsghluythksqh", "gdzutwgjofowhryrubnxkahocqjzwwagqid",
                "ddeoincygycdpeh", "yznmojdhbeomyjqptltpugzceyzenflfnhrptuug", "ejuisks",
                "teiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoi", "mrwnxhaqfezeeabuacyswollycgio",
                "qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav",
                "wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq",
                "ibxhtobuolmllbasaxlanjgalgmbjuxmqpadllryaobcucdeqc",
                "ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv",
                "rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb",
                "pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh",
                "akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd",
                "vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr",
                "ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw",
                "oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago",
                "bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn",
                "ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg",
                "xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq",
                "qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi",
                "itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq",
                "nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx",
                "ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl",
                "etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd",
                "ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh",
                "vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx",
                "yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth",
                "wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl",
                "yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo",
                "lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr",
                "idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb",
                "ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds",
                "jjtkmalhmrknaasskjnixzwjgvusbozslrribgazdhaylaxobj",
                "nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi",
                "egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl",
                "ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala",
                "azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz",
                "yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu",
                "tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk",
                "jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq",
                "bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch",
                "bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob",
                "koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq",
                "boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa",
                "jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar",
                "zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb",
                "izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct",
                "rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq",
                "xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc",
                "ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy",
                "jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj",
                "pdbsbjnrqzrbmewmdkqqhcpzielskcazuliiatmvhcaksrusae",
                "nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu",
                "hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr",
                "uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl",
                "awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf"}));
  }
}
