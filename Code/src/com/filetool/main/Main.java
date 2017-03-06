package com.filetool.main;

import com.cacheserverdeploy.deploy.Deploy;
import com.filetool.util.FileUtil;
import com.filetool.util.LogUtil;

/**
 * 
 * 工具入口
 * 
 * @version  [版本号, 2017-1-9]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Main
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("please input args: graphFilePath, resultFilePath");
            return;
        }

        String graphFilePath = args[0];
        String resultFilePath = args[1];

        LogUtil.printLog("Begin");

        // 璇诲彇杈撳叆鏂囦欢
        String[] graphContent = FileUtil.read(graphFilePath, null);

        // 鍔熻兘瀹炵幇鍏ュ彛
        String[] resultContents = Deploy.deployServer(graphContent);

        // 鍐欏叆杈撳嚭鏂囦欢
        if (hasResults(resultContents))
        {
            FileUtil.write(resultFilePath, resultContents, false);
        }
        else
        {
            FileUtil.write(resultFilePath, new String[] { "NA" }, false);
        }
        LogUtil.printLog("End");
    }
    
    private static boolean hasResults(String[] resultContents)
    {
        if(resultContents==null)
        {
            return false;
        }
        for (String contents : resultContents)
        {
            if (contents != null && !contents.trim().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

}
