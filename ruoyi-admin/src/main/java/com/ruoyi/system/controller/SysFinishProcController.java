package com.ruoyi.system.controller;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysFinishProc;
import com.ruoyi.system.service.ISysFinishProcService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 完成情况Controller
 *
 * @author 林鹏群
 * @date 2019-10-09
 */
@Controller
@RequestMapping("/system/finish")
public class SysFinishProcController extends BaseController
{
    private String prefix = "system/finish";

    @Autowired
    private ISysFinishProcService sysFinishProcService;
    @Autowired
    private ISysUserService sysUserService;

    @RequiresPermissions("system:finish:view")
    @GetMapping()
    public String finish()
    {
        return prefix + "/finish";
    }

    /**
     * 查询完成情况列表
     */
    @RequiresPermissions("system:finish:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysFinishProc sysFinishProc)
    {
        startPage();
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcList(sysFinishProc);
        return getDataTable(list);
    }

    @RequiresPermissions("system:finish:view")
    @GetMapping("/total")
    public String total()
    {
        return prefix + "/total";
    }

    @GetMapping("/music")
    public String music()
    {
        return prefix + "/music";
    }

    @ResponseBody
    @GetMapping("/music/list")
    public JSONArray musicList()
    {


        String music  =  "[{\n" +
                "        'name': '野狼disco后台数据',\n" +
                "        'artist': '宝石Gem',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017104adaf0ed80c0810d447bf7639ce959c9.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/gem.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '像我这样的人',\n" +
                "        'artist': '毛不易',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201710e732756d2e1a655510b44cda2a738230.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/maobuyi.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '孤芳自赏',\n" +
                "        'artist': '杨小壮',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709590096f9e347273e92be5dc4edb9a298.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/yangxiaozhuang.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '别想她',\n" +
                "        'artist': '小阿枫',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017106e77b70c1bf77f18c8ec76923ebd0dfd.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/xiaoafeng.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '最远的你是我最近的爱',\n" +
                "        'artist': '小阿枫',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017106759131627030022bcf61b2483c95b7d.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/xiaoafeng.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '想死却又不敢',\n" +
                "        'artist': '井胧',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201710cf17b19a8dbd3fa7c38a308634805054.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/jinglong.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '把孤独当做晚餐',\n" +
                "        'artist': '南铃子',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20171075db5ea1db8d85544e0504525ddb41c7.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/nanlingzi.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': 'Lil Mama',\n" +
                "        'artist': 'Jain',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201710c3ab967db02f7b6677adf955d656000c.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Jain.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '说好不哭',\n" +
                "        'artist': '周杰伦',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709f61ebb03164c3d6c9710a21a179a10fc.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhoujielun.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '很任性',\n" +
                "        'artist': '兔子牙',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709913b8c97cca2bf8971271451c5790f91.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/tuziya.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '小白兔遇上卡布奇诺',\n" +
                "        'artist': '兔子牙',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017090bbe1163e2af25399111b5b0fd703470.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/tuziya.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '红昭愿',\n" +
                "        'artist': '音阙诗听',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709ff59158a12f136da74e7012ab1bcbaaf.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/yinqueshiting.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '我曾',\n" +
                "        'artist': '隔壁老樊',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709d23738a1aa4999a20dfd6488cb26533c.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/gebilaofan.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '多想在平庸的生活拥抱你',\n" +
                "        'artist': '隔壁老樊',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017096aaeb0981717945d1546bd21d2108e89.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/gebilaofan.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '走马',\n" +
                "        'artist': '摩登兄弟',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709000b24cfd2593c7c136badda5ec809ff.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/modengxiongdi.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '病变',\n" +
                "        'artist': '江澈',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709099e1e4aeb20f94045d6dd07de58800b.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/jiangche.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '浪人琵琶',\n" +
                "        'artist': '胡66',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017090830b460562b4a65dcc61dfa5d1df2b0.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/hu66.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '芒种',\n" +
                "        'artist': '赵方婧',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709de60ddd81a959edc6408cd7773eaabe5.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhaofangqian.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '逆流成河',\n" +
                "        'artist': '金南玲',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170989d8ab68faddb1bc5384a56826f26408.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/jinnanling.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '写给黄淮',\n" +
                "        'artist': '张怡',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017092abe6aaaa1103da4b97ff713be8adca3.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhangyi.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '东西',\n" +
                "        'artist': '林俊呈',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017099a0a2f7a22c6ad9bd31696cc2748c558.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/linjunchen.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '选择失忆',\n" +
                "        'artist': '季彦霖',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709119f04d3e2ce4abd901a0c152a79155a.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/bukaopu.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '38度6',\n" +
                "        'artist': '黑龙',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170966d18766b320de17ef0e0473dcb7cac9.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/heilong.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '童话镇',\n" +
                "        'artist': '陈一发',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170958b6f5008ad538fde6286714a3457134.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/chenyifa.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '夜之光',\n" +
                "        'artist': '花姐',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709448c732c15766ac6e9aa7492392a3e6a.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/huajie.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '那个人',\n" +
                "        'artist': '周延英',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709a9791d8f858664a5dc4c4be0e9abbc8e.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhouyanying.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '9420',\n" +
                "        'artist': '麦小兜',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170991e46489ebf15863617f1717a62432ec.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/maixiaodou.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '春风吹',\n" +
                "        'artist': '阿冷',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709500d91f867746d8d7ab5b7b4e0f515f8.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/aleng.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '来自天堂的魔鬼',\n" +
                "        'artist': '邓紫棋',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170997c94547de17269fad3b500da6573388.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/dengziqi.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '倒数',\n" +
                "        'artist': '邓紫棋',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017090625979aa7765daa48cd6307536eb8f0.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/dengziqi.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '光年之外',\n" +
                "        'artist': '邓紫棋',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170978dd9e59b83a77f1042ea9bcb8ab51c2.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/dengziqi.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '不再犹豫',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709ab18fbea92cdc7baf7b64e8593965d6b.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '大地',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170948dd15d6dcdefc7317ac54793b2869d7.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '光辉岁月',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017098c91e41c0e93bbb6b1bcedaafb7672ad.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '海阔天空',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709931678da33cb95dc48cedf29410e83c6.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '灰色轨迹',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709bb5bc3bd7122c57f88e6baf01137cda2.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '冷雨夜',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709dd02dfb49c5f0f8e9b2cf96c05185100.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '情人',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170949463626e8874351c6daafc38a0ad08a.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '谁伴我闯荡',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709b0ff969b8688771883d800885d6ca92f.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '喜欢你',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709bc3acc74670d5562ee5c82b22cd48d4d.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '真的爱你',\n" +
                "        'artist': 'Beyond',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017095cd8d19ba89c69a2442c92545f9b26a5.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Beyond.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': 'The Spectre',\n" +
                "        'artist': 'AlanWalker',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709c31e703afe60187e641711a254fafba1.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/AlanWalker.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    },  {\n" +
                "        'name': 'All Falls Down',\n" +
                "        'artist': 'AlanWalker',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709be3ab1e1e0fb188aa1852e72da1dc8ea.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/AlanWalker.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    },  {\n" +
                "        'name': 'Alone',\n" +
                "        'artist': 'AlanWalker',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709a5191d5fad7b95dd123fe452f9663e40.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/AlanWalker.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Faded',\n" +
                "        'artist': 'AlanWalker',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170912393568fe8c282604a28d254c8110ce.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/AlanWalker.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'PDD 洪荒之力',\n" +
                "        'artist': 'Hoaprox',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709cc6971a4ccc5bc0c7fdc59042501072e.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Hoaprox.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Kattrina',\n" +
                "        'artist': 'Fly Project',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709520d0db9df76ca19c3949724acb20fd6.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Hoaprox.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Zuehlsdorff',\n" +
                "        'artist': 'Vicetone',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017097eaacdf1b9a7cef5b0140bc30d3f18e3.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Hoaprox.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Run Free',\n" +
                "        'artist': 'Deep Chills',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017095b1b59caa13b178a88b0526a3936cb94.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/DeepChills.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Something Just Like This',\n" +
                "        'artist': 'The Chainsmokers',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017093560974816d74c1cd9cf9e20dadda1e3.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/TheChainsmokers.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Wild',\n" +
                "        'artist': 'Monogem',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017094725268e3dfc263a3bc74c777fbdab69.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Monogem.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Sunshine Girl',\n" +
                "        'artist': 'Moumoon',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709904a162c94ca914eedead51467ab1d33.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/Moumoon.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Friendships (Original Mix)',\n" +
                "        'artist': 'Pascal Letoublon',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017092cc5a2c2cf6f96df777c6185f3ce516e.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/PascalLetoublon.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Williams - Lullaby',\n" +
                "        'artist': 'R3hab,Mike',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709dbf488e54b2627062be6c89533fc2b7a.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/R3hab.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Move Your Body (Alan Walker Remix)',\n" +
                "        'artist': 'Sia,Alan Walker',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017093c76f24b13ad95e425f31b3e72c98868.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/AlanWalker.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Unity',\n" +
                "        'artist': 'The Fat Rat',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170984c2b9cddf62de6f92c750e741a05bf5.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/TheFatRat.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': 'Seve',\n" +
                "        'artist': 'Tez Cadey',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017099ba6886f1ca137c1fc111b60ee889e41.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/TezCadey.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '一曲相思',\n" +
                "        'artist': '阿悠悠',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709349a81106814fe1223c09d55922f4eb0.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/ayouyou.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '流浪',\n" +
                "        'artist': '半阳',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709b1b4f16754a3c39c6a5c874cd6216e97.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/banyang.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '画',\n" +
                "        'artist': '赵雷',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709cb4cf70ca3124641ed69329cb8be1f72.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhaolei.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '说书人',\n" +
                "        'artist': '暗杠,寅子',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017090011fd748e532cb65f783a535b096ead.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/angang.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '不染',\n" +
                "        'artist': '简弘亦',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017092e3dab67749f57f9c2036c49e8b93f8d.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/jianhongyi.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '陷阱',\n" +
                "        'artist': '王北车',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017092fcf3a6c7acbcce7cc8dee4bee2a0386.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/wangbeiche.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '遥远的你',\n" +
                "        'artist': '不靠谱组合',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709993bf616603dcc0b113e4087a4f9f198.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/bukaopu.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '月牙湾',\n" +
                "        'artist': '刘至佳',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709c2587b9032bf29ed1adc8d4f8d886730.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/liuzhijia.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '去年夏天',\n" +
                "        'artist': '王大毛',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709a4225d4dc172ed9fdf04f6c0fb94818f.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/wangdamao.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '带你去旅行',\n" +
                "        'artist': '校长',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017099891c228253904a5b68ae88e774c15b6.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/xiaozhang.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '心如止水',\n" +
                "        'artist': 'Ice Paper',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709b616649065efb4c41284b0a51e223b01.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/IcePape.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '侧脸',\n" +
                "        'artist': '于果',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709fb29ee5c7ece1d0b714d80da01698d44.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/yuguo.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '绿色',\n" +
                "        'artist': '陈雪凝',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170980188533363aa5b62197eadecffa208f.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/chenxuening.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '出山',\n" +
                "        'artist': '花粥',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709cca8ca3ca0f7bb1052cdf0a53ea7dc2e.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/huazhou.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '遥不可及的你',\n" +
                "        'artist': '花粥',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709f9c6fad10c12bd695d1835e5364540d1.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/huazhou.jpg',\n" +
                "        'theme': '#ebd0c2'\n" +
                "    }, {\n" +
                "        'name': '相思如意',\n" +
                "        'artist': '兔子牙',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/2017097a8f93bb05ed5f1cbdd0bdb62c0da6da.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/tuziya.jpg',\n" +
                "        'theme': '#505d6b'\n" +
                "    }, {\n" +
                "        'name': '江南夜色',\n" +
                "        'artist': '程响',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709a7500eb455e294d73357fba05fbcb105.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/chengxiang.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '过客',\n" +
                "        'artist': '周思涵',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709af292a657120b34701f7ad85572a33ae.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/zhousihan.jpg',\n" +
                "        'theme': '#505d6b'\n" +
                "    }, {\n" +
                "        'name': '年少有为',\n" +
                "        'artist': '李荣浩',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709ee8b60fc26c4b70c40ae6486dc38b573.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/lironghao.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '曾经的你',\n" +
                "        'artist': '许巍',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/20170979819642dc26a12e0bfc0dc55fda98d5.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/xuwei.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }, {\n" +
                "        'name': '出现又离开',\n" +
                "        'artist': '梁博',\n" +
                "        'url': 'http://vip.baidu190.com/uploads/2017/201709dfb8f38add06e670321668e7386160c7.mp3',\n" +
                "        'cover': 'http://ruoyi.vip/music/cover/liangbo.jpg',\n" +
                "        'theme': '#46718b'\n" +
                "    }]";

        JSONArray paramsObj = JSONArray.parseArray(music);
        return paramsObj;
    }

    /**
     * 查询完成情况列表
     */
    @RequiresPermissions("system:finish:list")
    @PostMapping("/listTotal")
    @ResponseBody
    public TableDataInfo listTotal(SysFinishProc sysFinishProc)
    {
        startPage();
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcListTotalScore(sysFinishProc);
        return getDataTable(list);
    }

    /**
     * 完成度卡片
     */
    @GetMapping("/card")
    public String card(SysFinishProc sysFinishProc,ModelMap mmap)
    {
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcListCard(sysFinishProc);
        mmap.put("list", list);
        return prefix + "/card";
    }

    /**
     * 导出完成情况列表
     */
    @RequiresPermissions("system:finish:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysFinishProc sysFinishProc)
    {
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcList(sysFinishProc);
        ExcelUtil<SysFinishProc> util = new ExcelUtil<SysFinishProc>(SysFinishProc.class);
        return util.exportExcel(list, "finish");
    }

    /**
     * 新增完成情况
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存完成情况
     */
    @RequiresPermissions("system:finish:add")
    @Log(title = "完成情况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysFinishProc sysFinishProc)
    {
        return toAjax(sysFinishProcService.insertSysFinishProc(sysFinishProc));
    }

    /**
     * 修改完成情况
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysFinishProc sysFinishProc = sysFinishProcService.selectSysFinishProcById(id);
        mmap.put("sysFinishProc", sysFinishProc);
        return prefix + "/edit";
    }

    /**
     * 修改完成情况
     */
    @GetMapping("/showSkill/{id}")
    public String showSkill(@PathVariable("id") String id, ModelMap mmap)
    {

        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setUserId(id);
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcListSectionScore(sysFinishProc);

        mmap.put("hyjy", 0);
        mmap.put("xmjy", 0);
        mmap.put("jsnl", 0);
        mmap.put("zxnl", 0);
        mmap.put("zhnl", 0);
        mmap.put("zysy", 0);

        for (SysFinishProc obj :list) {
            mmap.put(obj.getEx1(), obj.getScore());
        }

        mmap.put("userName", sysUserService.selectUserById(id).getUserName());
        return prefix + "/showSkill";
    }

    /**
     * 修改保存完成情况
     */
    @RequiresPermissions("system:finish:edit")
    @Log(title = "完成情况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysFinishProc sysFinishProc)
    {
        return toAjax(sysFinishProcService.updateSysFinishProc(sysFinishProc));
    }

    /**
     * 删除完成情况
     */
    @RequiresPermissions("system:finish:remove")
    @Log(title = "完成情况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysFinishProcService.deleteSysFinishProcByIds(ids));
    }
}
