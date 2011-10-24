#!/usr/bin/env ruby

require 'nokogiri'

SOURCE_URL = ARGV[0] || 'http://en.wikipedia.org/wiki/ISO_3166-1'
OUTPUT_FILENAME = ARGV[1] || 'iso3166.colonized'

INPUT_FILENAME = File.basename(SOURCE_URL)

unless File.exists?(INPUT_FILENAME)

  WGET=`which wget`
  unless WGET
    puts 'Unable to find wget'
    exit 1
  end

  `wget #{SOURCE_URL}`
end

File.open(OUTPUT_FILENAME, 'w') { |out|
  File.open(INPUT_FILENAME) { |html|
    doc = Nokogiri::HTML(html)
    doc.xpath("//div[@id='bodyContent']//table[@class='wikitable sortable']/tr").each { |tr|
      td = tr/:td
      unless td.empty?
        name = (td[0]/:a).text()
        a2 = td[1].text()     
        a3 = td[2].text()
        num = td[3].text()
        out.puts [name, a2, a3, num].join('|')
      else
        header = []
        tr = tr/:th
        tr.each {|e| header << e.text() }
        out.puts header.join('|')
      end
    }
  }
}

#KTHXBAI
