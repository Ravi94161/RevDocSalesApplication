<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>selectDateOnSearchCard_android</name>
   <tag></tag>
   <elementGuidId>0dc36b56-129f-4b82-a146-10b03363642f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <locator>((//android.view.ViewGroup[@content-desc=&quot;searchCard&quot;])[${cardIndex}]//android.widget.TextView[contains(@text, 'Sun') or contains(@text, 'Mon') or contains(@text, 'Tue') or contains(@text, 'Wed') or contains(@text, 'Thu') or contains(@text, 'Fri') or contains(@text, 'Sat')])[${dateIndex}]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
